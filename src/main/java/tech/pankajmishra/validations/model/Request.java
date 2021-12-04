package tech.pankajmishra.validations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.pankajmishra.validations.annotations.PmValidRequest;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@PmValidRequest
public class Request {
    private String id;
}
