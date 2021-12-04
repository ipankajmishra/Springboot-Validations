package tech.pankajmishra.validations.controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pankajmishra.validations.annotations.Valid;
import tech.pankajmishra.validations.model.Request;

@RestController
@RequestMapping("/home")
@Validated
public class MainController {

    @GetMapping("/getSum")
    public int getSum(@Valid @RequestBody Request request){
        return 100;
    }

}
