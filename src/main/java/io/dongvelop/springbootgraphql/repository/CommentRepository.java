package io.dongvelop.springbootgraphql.repository;

import io.dongvelop.springbootgraphql.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description 댓글 레포지토리
 */
//@Repository
@GraphQlRepository // GraphQL 스키마를 자동 생성 + 내부적으로 @Repository 구현
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostId(final Long postId);
}
