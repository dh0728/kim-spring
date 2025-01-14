package me.silvernine.jwt_tutorial.repository;

import me.silvernine.jwt_tutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "authorities") //@EntityGraph 쿼리가 수행될 시 Lazy조회가 아니라 Eager 조회로 authorities정보를 같이 가져옴
    Optional<User> findOneWithAuthoritiesByUsername(String username);

}
