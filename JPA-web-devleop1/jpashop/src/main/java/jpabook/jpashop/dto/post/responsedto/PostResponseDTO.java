package jpabook.jpashop.dto.post.responsedto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponseDTO {

    private Long id;
    private String title;
    private String content;
    private String imageUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private Long userId; // 게시글 작성자의 ID
    private Set<Long> commentIds; // 게시글에 달린 댓글들의 ID
    private Set<Long> likeIds; // 게시글에 달린 좋아요들의 ID

}
