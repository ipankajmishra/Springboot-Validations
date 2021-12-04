package tech.pankajmishra.validations.annotations;

import java.lang.annotation.*;

/**
 * General Annotation to extend any T annotation.
 *
 * @author Pankaj Mishra
 * @since Dec 2021
 * @version v1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface PmExtends {
    Class<? extends Annotation> value();
}
