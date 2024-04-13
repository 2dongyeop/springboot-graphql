package io.dongvelop.springbootgraphql.service;

import io.dongvelop.springbootgraphql.model.Comment;
import io.dongvelop.springbootgraphql.model.Post;
import io.dongvelop.springbootgraphql.model.User;
import io.dongvelop.springbootgraphql.payload.request.RequestComment;
import io.dongvelop.springbootgraphql.repository.CommentRepository;
import io.dongvelop.springbootgraphql.repository.PostRepository;
import io.dongvelop.springbootgraphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description Comment Service
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Comment saveComment(final Long postId, final RequestComment request) {
        log.info("postId[{}], request[{}]", postId, request);

        final Post post = postRepository.findById(postId).orElseThrow(() -> {
            log.info("postId[{}] not found", postId);
            return new NullPointerException("postId[" + postId + "] not found");
        });

        final User user = userRepository.findById(1L).orElseThrow(() -> {
            log.info("userId[{}] not found", 1L);
            return new NullPointerException("userId[" + 1L + "] not found");
        });

        return commentRepository.save(new Comment(request.content(), user, post));
    }

    public List<Comment> getCommentsByPostId(final Long postId) {
        log.info("postId[{}]", postId);
        return commentRepository.findAllByPostId(postId);
    }
}
