package tech.pankajmishra.validations.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * If you mark any incoming requestBody as @Valid, then it will
 * go for the API validations.
 * @author Pankaj Mishra
 * @since Dec 2021
 * @version v1
 */

@PmExtends(javax.validation.Valid.class)
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
public @interface Valid {
}
