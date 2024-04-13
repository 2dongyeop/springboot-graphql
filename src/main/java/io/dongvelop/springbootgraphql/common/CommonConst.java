package io.dongvelop.springbootgraphql.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description 공통 상수 정의 클래스
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonConst {

    /**
     * 요청 헤더 관련 상수
     */
    public static final String AUTHORIZATION = "Authorization";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
}