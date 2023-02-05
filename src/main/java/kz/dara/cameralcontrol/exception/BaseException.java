package kz.dara.cameralcontrol.exception;

import kz.dara.cameralcontrol.model.dto.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public abstract class BaseException extends RuntimeException {

    private ErrorResponse errorResponse;

}
