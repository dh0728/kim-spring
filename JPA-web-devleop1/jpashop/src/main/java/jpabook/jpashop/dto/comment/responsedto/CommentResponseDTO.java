package jpabook.jpashop.dto.comment.responsedto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDTO {

    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Long userId; // 댓글 작성자의 ID
    private Long postId; // 댓글 달린 게시글 아이디


}
