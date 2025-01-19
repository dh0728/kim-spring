package studty.data_jpa.dto;

import lombok.Data;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import studty.data_jpa.entity.Member;

@Data
public class MemberDto {

    private Long id;
    private String name;
    private String teamName;

    public MemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.name = username;
        this.teamName = teamName;
    }

}
