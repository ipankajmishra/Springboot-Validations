package tech.pankajmishra.validations.service;

import org.springframework.stereotype.Service;
import tech.pankajmishra.validations.model.Bucket;
import tech.pankajmishra.validations.model.RateLimiterVO;

import java.util.HashMap;
import java.util.Map;

@Service
public class RateLimiter {

    static Map<String, Bucket> buckets = new HashMap<>();
    static int interval = 60*1000;
    static int requests = 1;

    public RateLimiterVO rateLimit(String customerId){
        RateLimiterVO rateLimiterVO = new RateLimiterVO();
        long currentTimestamp = System.currentTimeMillis();
        Map map = buckets;
        Bucket bucket = getBucket(customerId, currentTimestamp);
        long fullFillTimestamp = bucket.getLastRefillTimestamp() + (interval);
        if(currentTimestamp<=fullFillTimestamp && bucket.getRequests()>0){
            bucket.setRequests(bucket.getRequests()-1);
            rateLimiterVO.setBucket(bucket);
            rateLimiterVO.setValid(true);
            return rateLimiterVO;
        }
        else if(currentTimestamp<=fullFillTimestamp && bucket.getRequests()==0){
            rateLimiterVO.setBucket(bucket);
            rateLimiterVO.setValid(false);
            rateLimiterVO.setFulfillmentAfter(fullFillTimestamp);
            return rateLimiterVO;
        }
        bucket.setLastRefillTimestamp(currentTimestamp);
        bucket.setRequests(requests-1);
        rateLimiterVO.setBucket(bucket);
        rateLimiterVO.setValid(true);
        return rateLimiterVO;
    }

    Bucket getBucket(String id, long timeStamp){
        if(buckets.containsKey(id)){
            return buckets.get(id);
        }
        Bucket bucket
                = new Bucket();
        bucket.setCustomerId(id);
        bucket.setRequests(requests);
        bucket.setLastRefillTimestamp(timeStamp);
        buckets.put(id,bucket);
        return bucket;
    }

}
