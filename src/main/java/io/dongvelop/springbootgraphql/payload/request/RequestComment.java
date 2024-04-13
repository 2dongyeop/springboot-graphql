package io.dongvelop.springbootgraphql.payload.request;

import jakarta.validation.constraints.NotBlank;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description 댓글 요청 페이로드
 */
public record RequestComment(
        @NotBlank String content
) {
}
