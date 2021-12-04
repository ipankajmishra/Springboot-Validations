package tech.pankajmishra.validations.validators;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pankajmishra.validations.annotations.PmConstraintValidator;
import tech.pankajmishra.validations.annotations.PmValidRequest;
import tech.pankajmishra.validations.model.RateLimiterVO;
import tech.pankajmishra.validations.model.Request;
import tech.pankajmishra.validations.service.RateLimiter;

import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

@Service
public class PmValidator<V extends Annotation,R> implements PmConstraintValidator<V, R> {
    public static Map<String,RateLimiterVO> justProcessed = new HashMap<>();
    @Autowired
    RateLimiter rateLimiter;
    @Override
    public void initialize(V constraintAnnotation) {
        PmConstraintValidator.super.initialize(constraintAnnotation);
    }

    @SneakyThrows
    @Override
    public boolean isValid(R o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

    @SneakyThrows
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) throws Exception {
        try {
            return isValidRequest(id);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean isValidRequest(String id) throws Exception {
        boolean finalVal;
        String err = "Something went wrong!";
        if(justProcessed.containsKey(id)){
            RateLimiterVO rateLimiterVO = new RateLimiterVO();
            rateLimiterVO.setValid(justProcessed.get(id).isValid());
            boolean value = justProcessed.get(id).isValid();
            if(!value){
                String tLeft = "few";
                long timeLeft = (justProcessed.get(id).getFulfillmentAfter()-System.currentTimeMillis())/1000;
                if(timeLeft>0){
                    tLeft = String.valueOf(timeLeft);
                }
                err = "Your last request is still in processing. Please try again after "+ tLeft +" seconds.";
            }
            justProcessed.remove(id);
            finalVal =  value;
        }else{
            RateLimiterVO rateLimiterVO = rateLimiter.rateLimit(id);
            justProcessed.put(id, rateLimiterVO);
            finalVal = rateLimiterVO.isValid();
            String tLeft = "few";
            long timeLeft = (rateLimiterVO.getFulfillmentAfter()-System.currentTimeMillis())/1000;
            if(timeLeft>0){
                tLeft = String.valueOf(timeLeft);
            }
            err = "Your last request is still in processing. Please try again after "+ tLeft +" seconds.";
        }
        if(!finalVal){
            throw new Exception(err);
        }
        justProcessed.remove(id);
        return true;
    }
}
