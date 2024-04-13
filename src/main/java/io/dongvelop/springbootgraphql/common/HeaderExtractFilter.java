package io.dongvelop.springbootgraphql.common;

import io.dongvelop.springbootgraphql.common.CommonConst;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description 모든 요청에서 헤더 추출 클래스
 */
@Slf4j
public class HeaderExtractFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {

        final String requestURI = request.getRequestURI();
        final String authorization = request.getHeader(CommonConst.AUTHORIZATION);
        final String contentType = request.getHeader(CommonConst.CONTENT_TYPE_KEY);

        log.info("============ Header Start ============");
        log.info("requestURI[{}]", requestURI);
        log.info("authorization[{}]", authorization);
        log.info("contentType[{}]", contentType);
        log.info("============= Header End =============");

        filterChain.doFilter(request, response);
    }
}