package studty.data_jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import studty.data_jpa.dto.MemberDto;
import studty.data_jpa.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);


    @Query("select m from Member m where m.username= :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    @Query("select m.username from Member m")
    List<String> findUsernameList();


    //@Query 값 , DTO 조회하기
    @Query("select new studty.data_jpa.dto.MemberDto(m.id, m.username, t.name)" + "from Member m join m.team t")
    List<MemberDto> findMemberDto();

    //파라미터 바인딩(이름기반)
    @Query("select m from Member m where m.username = :name")
    Member findMembers(@Param("name") String username);

    //컬랙션 파라미터 바인딩
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);


    // 반환 타입
//    List<Member> findByUsername(String name); //컬랙션
//    Member findByUserName(String name);
//    Optional<Member> findByUsername(String name); // 단건 Optional


    //스프링 데이터 JPA 페이징과 정렬
    Page<Member> findByUsername(String name, Pageable pageable); //count 쿼리 사용
//    Slice<Member> findByUsername(String name, Pageable pageable); //count 쿼리 사용 안함
//    List<Member> findByUsername(String name , Pageable pageable); //count 쿼리 사용 안함
//    List<Member> findByUsername(String name, Sort sort);

    // 사용시 페이지 유지하면서 엔티티를 DTO로 변환하는 법
//    Page<Member> page =memberRepository.findByUsername('AAA', pageRequest);
//    Page<MemberDTO> dtopage = page.map(m -> new MemberDto());

}
