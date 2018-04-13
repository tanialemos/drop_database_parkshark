package be.dropdatabase.parkshark.division;

import be.dropdatabase.parkshark.utilities.exceptions.ParkSharkIllegalFieldFoundException;
import be.dropdatabase.parkshark.utilities.exceptions.ParkSharkUnknownResourceException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = {"be.dropdatabase.parkshark"})
public class GlobalConrollerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ParkSharkUnknownResourceException.class)
    public ResponseEntity<String> convertUnknownIdException(final ParkSharkUnknownResourceException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ParkSharkIllegalFieldFoundException.class)
    public ResponseEntity<String> convertIllegalFieldFoundException(final ParkSharkIllegalFieldFoundException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
    public ResponseEntity<String> convertConstraintViolationException(final ConstraintViolationException exception){

        return new ResponseEntity<>("A division with this name already exists", HttpStatus.BAD_REQUEST);
    }
}
