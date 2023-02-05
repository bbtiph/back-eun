package kz.dara.cameralcontrol.model.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
public class ErrorResponse implements Serializable {

    private final String errorMsg;
    private final HttpStatus responseStatus;

    public ErrorResponse(String errorMsg, HttpStatus responseStatus) {
        this.errorMsg = errorMsg;
        this.responseStatus = responseStatus;
    }
}
