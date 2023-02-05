package kz.dara.cameralcontrol.exception;

import kz.dara.cameralcontrol.model.dto.ErrorResponse;
import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends BaseException {

    public ObjectNotFoundException(final String message) {
        super(new ErrorResponse(message, HttpStatus.NOT_FOUND));
    }
}
