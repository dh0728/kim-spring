package studty.data_jpa.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id","username","age"}) //연관괸계 테이블은 toString 하지 말기
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY) //연관관계 테이블은 모두 LAZY로 설정해야함
    @JoinColumn(name = "team_id")
    private Team team;


    public Member(String username){
        this.username = username;
    }

    public Member(String username, int age, Team team){
        this.username = username;
        this.age = age;
        if (team != null){
            changeTeam(team);
        }
    }

    public void changeUsername(String username) {
        this.username = username;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

}
