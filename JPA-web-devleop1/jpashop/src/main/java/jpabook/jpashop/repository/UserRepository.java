package jpabook.jpashop.repository;

import jpabook.jpashop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 사용자 이름으로 사용자 찾기
    Optional<User> findByUsername(String username);

    // 이메일로 사용자 찾기
    Optional<User> findByEmail(String email);

    // 사용자 이름 존재 여부 확인
    boolean existsByUsername(String username);

    // 사용자 이름 존재 여부 확인
    boolean existsByEmail(String email);
}
