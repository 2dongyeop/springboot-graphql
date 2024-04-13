package io.dongvelop.springbootgraphql.config;

import io.dongvelop.springbootgraphql.common.HeaderExtractFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description CORS 및 필터 관련 설정 클래스
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${cors.allowed.mapping}")
    private String corsMapping;

    @Value("${cors.allowed.origins}")
    private String[] corsOrigins;

    @Value("${cors.allowed.headers}")
    private String[] corsHeaders;

    @Value("${cors.allowed.methods}")
    private String[] corsMethods;

    @Bean
    public FilterRegistrationBean<HeaderExtractFilter> logFilter() {
        return new FilterRegistrationBean<>(new HeaderExtractFilter());
    }

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping(corsMapping)
                .allowedOriginPatterns(corsOrigins)
                .allowedMethods(corsMethods)
                .allowedHeaders(corsHeaders)
                .allowCredentials(true)
                .maxAge(3600);
    }
}
