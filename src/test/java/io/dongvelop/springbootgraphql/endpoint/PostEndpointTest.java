package io.dongvelop.springbootgraphql.endpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 18
 * @description 게시글 API 테스트
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class PostEndpointTest {


    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void viewAllPost() {

        // given
        final String requestUrl = "/graphql";
        final String methodName = "viewAllPost";
        final String query = "{\"query\":\"{" + methodName + "{ id title content } }\"}";

        // expected
        webTestClient.post()
                .uri(requestUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(query)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.data.viewAllPost").isArray();
    }
}