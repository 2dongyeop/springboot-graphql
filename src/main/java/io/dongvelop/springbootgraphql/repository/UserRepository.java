package io.dongvelop.springbootgraphql.repository;

import io.dongvelop.springbootgraphql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 이동엽(Lee Dongyeop)
 * @date 2024. 04. 13
 * @description 유저 레포지토리
 */
//@Repository
@GraphQlRepository
public interface UserRepository extends JpaRepository<User, Long> {
}
