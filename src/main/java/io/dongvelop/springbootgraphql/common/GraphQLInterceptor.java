package io.dongvelop.springbootgraphql.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 20
 * @description GraphQL 요청 인터셉터
 */
@Slf4j
@Component
public class GraphQLInterceptor implements WebGraphQlInterceptor {

    @Override
    public Mono<WebGraphQlResponse> intercept(final WebGraphQlRequest request, final Chain chain) {
        log.debug("request[{}]", request);
        log.debug("document[{}]", request.getDocument());
        log.debug("headers[{}]", request.getHeaders());
        return chain.next(request);
    }
}
