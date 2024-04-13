package io.dongvelop.springbootgraphql.service;

import io.dongvelop.springbootgraphql.model.Post;
import io.dongvelop.springbootgraphql.model.User;
import io.dongvelop.springbootgraphql.payload.request.RequestPost;
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
 * @description Post Service
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Transactional
    public Post viewPost(final Long postId) {
        log.info("postId[{}]", postId);
        final Post post = postRepository.findById(postId).orElseGet(() -> {
            log.info("postId[{}] not found", postRepository);
            return null;
        });

        if (post != null) {
            log.info("post[{}]'s view increase", post);
            post.increaseView();
        }
        return post;
    }

    @Transactional
    public Post savePost(final RequestPost request) {
        log.info("request[{}]", request);

        final User user = userRepository.findById(1L).orElseThrow(() -> {
            log.info("userId[{}] not found", 1L);
            return new NullPointerException("userId[" + 1L + "] not found");
        });

        return postRepository.save(new Post(request.title(), request.content(), user));
    }
}

