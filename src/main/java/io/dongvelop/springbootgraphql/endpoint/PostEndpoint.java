package io.dongvelop.springbootgraphql.endpoint;

import io.dongvelop.springbootgraphql.model.Post;
import io.dongvelop.springbootgraphql.payload.request.RequestPost;
import io.dongvelop.springbootgraphql.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description Post Endpoint
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class PostEndpoint {
    private final PostService postService;

    @QueryMapping
    public List<Post> viewAllPost() {
        return postService.findAllPost();
    }

    @MutationMapping
    public Post viewPost(@Argument final Long postId) {
        log.info("postId[{}]", postId);
        return postService.viewPost(postId);
    }

    @MutationMapping
    public Post savePost(@Argument @Valid final RequestPost request) {
        log.info("request[{}]", request);
        return postService.savePost(request);
    }
}
