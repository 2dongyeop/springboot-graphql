package io.dongvelop.springbootgraphql.exception;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 20
 * @description GraphQL Exception Resolver
 */
@Slf4j
@Component
public class GraphQLExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(final Throwable ex, final DataFetchingEnvironment env) {
        log.info("exception[{}]", ex);

        return ex instanceof CustomGraphQLException
                ? new CustomGraphQLException(ex.getMessage())
                : super.resolveToSingleError(ex, env);
    }
}
