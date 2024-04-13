package io.dongvelop.springbootgraphql.endpoint;

import io.dongvelop.springbootgraphql.model.Comment;
import io.dongvelop.springbootgraphql.payload.request.RequestComment;
import io.dongvelop.springbootgraphql.service.CommentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
 * @description Comment Endpoint
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class CommentEndpoint {

    private final CommentService commentService;

    @MutationMapping
    public Comment saveComment(@Argument @NotNull final Long postId,
                               @Argument @Valid final RequestComment request) {
        log.info("postId[{}], request[{}]", postId, request);
        return commentService.saveComment(postId, request);
    }

    @QueryMapping
    public List<Comment> getCommentsByPostId(@Argument final Long postId) {
        log.info("postId[{}]", postId);
        return commentService.getCommentsByPostId(postId);
    }
}
