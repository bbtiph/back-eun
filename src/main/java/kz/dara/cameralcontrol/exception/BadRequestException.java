package kz.dara.cameralcontrol.exception;

import kz.dara.cameralcontrol.model.dto.ErrorResponse;
import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {
    public BadRequestException(final String message) {
        super(new ErrorResponse(message, HttpStatus.BAD_REQUEST));
    }
}
