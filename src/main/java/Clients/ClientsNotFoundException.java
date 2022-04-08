package Clients;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientsNotFoundException extends Throwable {
    public ClientsNotFoundException(String message) {
        super(message);
    }
}
