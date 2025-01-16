package jpabook.jpashop.dto.post.requestdto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostUpdateRequestDTO {

    @Size(max =100, message = "Title must be less than 100 characters")
    private String title;

    private String content;

    private String imageUrl;

}
