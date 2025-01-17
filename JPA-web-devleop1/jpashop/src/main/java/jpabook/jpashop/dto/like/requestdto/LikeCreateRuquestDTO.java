package jpabook.jpashop.dto.like.requestdto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeCreateRuquestDTO {

    @NotBlank(message = "Post Id is required")
    private String postId; // 좋아요를 누를 게시글의 ID

    @NotBlank(message = "User ID is required")
    private Long userId; // 좋아요를 누른 사용자의 ID

}
