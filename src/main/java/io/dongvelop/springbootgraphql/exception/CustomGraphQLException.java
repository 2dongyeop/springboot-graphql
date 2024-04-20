package io.dongvelop.springbootgraphql.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.language.SourceLocation;
import lombok.Getter;

import java.util.List;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 20
 * @description 커스텀 예외 클래스
 */
@Getter
public class CustomGraphQLException extends GraphQLException implements GraphQLError {

    public CustomGraphQLException(final String message) {
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.CustomException;
    }
}
