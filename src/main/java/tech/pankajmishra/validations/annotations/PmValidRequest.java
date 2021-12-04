package tech.pankajmishra.validations.annotations;

import tech.pankajmishra.validations.validators.ListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validator used to check whether given request is
 * is valid from the respective retailerId or not.
 *
 * @author Pankaj Mishra
 * @since Dec 2021
 * @version v1
 */
@Constraint(validatedBy = {ListValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PmValidRequest {
    String message() default "Too many requests.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
