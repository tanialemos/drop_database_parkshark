package be.dropdatabase.parkshark.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParkSharkIllegalFieldFoundException extends ParkSharkGeneralException {
    public ParkSharkIllegalFieldFoundException(String field, String objectType, String action) {
        super(String.format("Illegal Parameter [%s] parameter on Object [%s] with operation [%s]", field, objectType, action));
    }
}
