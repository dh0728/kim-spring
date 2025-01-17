package jpabook.jpashop.dto.follow.requestdto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowCreateRequestDTO {

    @NotBlank(message = "Follower Id required")
    private Long followerId; //팔로워 사용자의 ID

    @NotBlank(message = "Following ID is required")
    private Long followingId; // 팔로잉하는 사용자의 ID
}
