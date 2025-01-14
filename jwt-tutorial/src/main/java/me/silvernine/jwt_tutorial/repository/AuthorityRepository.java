package me.silvernine.jwt_tutorial.repository;

import me.silvernine.jwt_tutorial.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
