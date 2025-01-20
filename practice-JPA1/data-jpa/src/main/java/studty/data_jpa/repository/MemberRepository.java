package studty.data_jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    // 스프링 데이터 JPA를 사용한 벌크성 수정 쿼리
    // 벌크성 수정, 삭제 쿼리는 @Modifing 사용 (영속성 컨텍스트)를 초기화 해야 함
    @Modifying
    @Query("update Member m set m.age = m.age +1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

    // @EntityGraph

    // fetch join의 일반적인 방법
    @Query("select m from Member m left join fetch m.team")
    List<Member> findAllFetchJoin();

    @Override
    @EntityGraph(attributePaths = {"team"})
    List<Member> findAll();

    // Query를 짜다가 fetch join만 살짝 추가하고 싶다면
    @EntityGraph(attributePaths = {"team"})
    @Query("select m from Member m")
    List<Member> findMemberEntityGraph();

    @EntityGraph(attributePaths = {"team"})
    List<Member> findEntityGraphByUsername(String username);


}
