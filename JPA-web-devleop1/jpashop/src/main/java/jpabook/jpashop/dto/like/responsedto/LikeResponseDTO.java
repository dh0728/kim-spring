package jpabook.jpashop.dto.like.responsedto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeResponseDTO {

    private Long id;
    private LocalDateTime createAt;

    private Long userId;
    private Long postId;

}