package tech.pankajmishra.validations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bucket {
    private int requests;
    private String customerId;
//    private int interval;
    private long lastRefillTimestamp;
}
