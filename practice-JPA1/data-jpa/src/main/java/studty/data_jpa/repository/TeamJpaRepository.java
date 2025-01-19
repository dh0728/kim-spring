package studty.data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studty.data_jpa.entity.Team;

public interface TeamJpaRepository extends JpaRepository<Team, Long> {

}
