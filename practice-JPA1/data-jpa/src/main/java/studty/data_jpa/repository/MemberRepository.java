package studty.data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studty.data_jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
