package Consultants;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ConsultantsNotFoundException extends Throwable{
    public ConsultantsNotFoundException(String message) {
        super(message);
    }
}
