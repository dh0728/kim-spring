package jpabook.jpashop.dto.follow.responsedto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowResponseDTO {

    private Long id;
    private LocalDateTime followedAt;

    private Long followerId;  // 팔로워 사용자의 ID
    private Long followingId; // 팔로잉하는 사용자의 ID

}
