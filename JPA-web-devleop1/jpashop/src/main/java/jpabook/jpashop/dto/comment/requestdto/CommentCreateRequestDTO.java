package jpabook.jpashop.dto.comment.requestdto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentCreateRequestDTO {

    @NotBlank(message = "Content is required")
    private String contnet;

    private Long postId;


}
