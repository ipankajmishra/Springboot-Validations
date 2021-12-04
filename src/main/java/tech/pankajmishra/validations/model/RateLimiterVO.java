package tech.pankajmishra.validations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RateLimiterVO {
    private boolean isValid;
    private Bucket bucket;
    private long fulfillmentAfter;
}
