package jpabook.jpashop.repository;

import jpabook.jpashop.Entity.Follow;
import jpabook.jpashop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    // 특정 팔로워와 특정 팔로잉 관계 찾기
    Optional<Follow> findByFollowerAndFollowing(User follower, User followed);

    // 특정 사용자가 팔로우한 모든 관계 찾기
    List<Follow> findByFollower(User follower);

    // 특정 사용자를 팔로우한 모든 관계 찾기
    List<Follow> findByFollowing(User following);
}
