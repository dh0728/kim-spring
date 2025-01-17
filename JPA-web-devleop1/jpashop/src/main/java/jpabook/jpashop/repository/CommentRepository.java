package jpabook.jpashop.repository;

import jpabook.jpashop.Entity.Comment;
import jpabook.jpashop.Entity.Post;
import jpabook.jpashop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 특정 게시글이 달린 모든 댓글 찾기
    List<Comment> findByPost(Post post);

    // 특정 사용자에 의해 작성된 모든 댓글 찾기
    List<Comment> findByUser(User user);

}
