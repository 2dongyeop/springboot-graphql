package io.dongvelop.springbootgraphql.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 20
 * @description 사용자 정의 예외
 */
@Getter
public class CustomException extends RuntimeException {

    private final HttpStatus httpStatus;

    public CustomException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
