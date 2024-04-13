package io.dongvelop.springbootgraphql.payload.request;

import jakarta.validation.constraints.NotBlank;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description 게시글 요청 페이로드
 */
public record RequestPost(
        @NotBlank(message = "title is empty")
        String title,

        @NotBlank(message = "content is empty")
        String content
) {
}
