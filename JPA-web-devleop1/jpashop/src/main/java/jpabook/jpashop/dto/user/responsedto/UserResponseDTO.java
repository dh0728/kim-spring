package jpabook.jpashop.dto.user.responsedto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private Long id;
    private String email;
    private String username;
    private String bio;
    private String profileImageUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private Set<Long> followingIds; // 사용자가 팔로잉하는 사용자들의 ID
    private Set<Long> followerIds; // 사용자를 팔로우하는 사용자들의 ID

}
