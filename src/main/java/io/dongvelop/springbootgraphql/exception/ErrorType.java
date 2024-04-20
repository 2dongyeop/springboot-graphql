package io.dongvelop.springbootgraphql.exception;

import graphql.ErrorClassification;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 20
 * @description 에러 발생시 errors.extension.classification 응답용 enum
 */
public enum ErrorType implements ErrorClassification {
    CustomException
}
