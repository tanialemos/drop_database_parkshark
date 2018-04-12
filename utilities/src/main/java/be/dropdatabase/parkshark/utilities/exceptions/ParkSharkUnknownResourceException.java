package be.dropdatabase.parkshark.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ParkSharkUnknownResourceException extends ParkSharkGeneralException {
    public ParkSharkUnknownResourceException(String id, String objectType) {
        super(String.format("No %s found with id %s", objectType, id));
    }
}
