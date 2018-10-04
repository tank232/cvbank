package tel.ran.group.cvbank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tel.ran.group.cvbank.exception.InputValidationException;
import tel.ran.group.cvbank.model.web.ErrorResponse;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = InputValidationException.class)
    public ResponseEntity<ErrorResponse> getErrorResponse(InputValidationException e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getErrorResponse(), HttpStatus.BAD_REQUEST);
    }
}
