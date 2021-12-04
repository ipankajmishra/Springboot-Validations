package tech.pankajmishra.validations.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public interface PmConstraintValidator<V extends Annotation, R> extends ConstraintValidator<V , R> {

    @Override
    default void initialize(V constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    boolean isValid(R o, ConstraintValidatorContext constraintValidatorContext);
}
