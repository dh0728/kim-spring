package me.silvernine.jwt_tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity //데이터베이스의 테이블과 1:1로 매핑되는 객체를 뜻함
@Table(name="`user`") //``안에 안넣으면 오류남
@Getter // Get, Set, Builder, Constructor 관련 코드는 Lombok 어노테이션으로 자동 생성 시킴
@Setter // 실무라고 하면 바꿔야 할듯
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //1씩 자동 증가
    private Long userId;

    @Column(name = "username" , length = 50, unique = true)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name= "nickname", length = 50)
    private String nickname;

    @Column(name = "activated", length = 50)
    private boolean activated;

//    private Author author;

    // @ManyToMany, @JoinTable은 User객체와 권한 객체를 다대다 관계를
    // 중계 테이블로 일대다, 다대일로 조인 테이블로 정의 한것
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name= "authority_name", referencedColumnName = "authority_name")})

    private Set<Authority> authorities;

}
