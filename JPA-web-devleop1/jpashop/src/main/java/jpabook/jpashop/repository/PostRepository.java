package jpabook.jpashop.repository;

import jpabook.jpashop.Entity.Post;
import jpabook.jpashop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 특정 사용자가 작성한 게시글 모두 찾기
    List<Post> findByUser(User user);

    // 제목에 특정 단어가 포함된 게시글 찾기
    List<Post> findByTitleContaining(String keyword);

    // 작성일 기준으로 정렬된 게시글 찾기
    List<Post> findTop10ByOrderByCreateAt();

}
