package tech.pankajmishra.validations.validators;


import lombok.SneakyThrows;
import tech.pankajmishra.validations.annotations.PmValidRequest;
import tech.pankajmishra.validations.model.Request;

import javax.validation.ConstraintValidatorContext;

public class ListValidator extends PmValidator<PmValidRequest,Request> {
    @SneakyThrows
    @Override
    public boolean isValid(Request request, ConstraintValidatorContext constraintValidatorContext) {
        return super.isValid(request.getId(), constraintValidatorContext);
    }
}
