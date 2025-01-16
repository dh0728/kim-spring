package jpabook.jpashop.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "follows", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"follow_id", "following_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Follow {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private LocalDateTime followedAt;

    // 팔로우
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id" , unique = false)
    private User follower;

    // 팔로잉
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_id" , nullable = false)
    private User following;

    @PrePersist
    protected void onCreate() {
        followedAt = LocalDateTime.now();
    }

}
