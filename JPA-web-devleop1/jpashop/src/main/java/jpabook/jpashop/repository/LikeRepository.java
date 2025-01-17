package jpabook.jpashop.repository;

import jpabook.jpashop.Entity.Like;
import jpabook.jpashop.Entity.Post;
import jpabook.jpashop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    // 특정 사용자와 특정 게시글에 대한 좋아요 찾기
    Optional<Like> findByUserAndPost(User user, Post post);

    // 특정 게시글에 달린 모든 좋아요 찾기
    List<Like> findByPost(Post post);

    // 특정 사용자가 누른 모든 좋아요 찾기
    List<Like> findByUser(User user);

}
