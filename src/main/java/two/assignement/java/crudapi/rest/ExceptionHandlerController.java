package two.assignement.java.crudapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import two.assignement.java.crudapi.ApplicationExceptions.ApplicationError;
import two.assignement.java.crudapi.ApplicationExceptions.PersonNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler
    public ResponseEntity<ApplicationError> personNotFoundHandler(PersonNotFoundException ex){
        ApplicationError error = new ApplicationError(HttpStatus.NOT_FOUND.value(),System.currentTimeMillis(),ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ApplicationError> genericExceptionHandler(Exception ex){
        ApplicationError error = new ApplicationError(HttpStatus.BAD_REQUEST.value(),System.currentTimeMillis(),ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
