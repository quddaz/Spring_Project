package Spring.data_jpa.Member;

import Spring.data_jpa.domain.member.entity.Member;
import Spring.data_jpa.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberJpaRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("맴버테스트")
    public void testMember(){
       Member member = Member.builder()
           .username("memberA")
           .build();
       memberRepository.save(member);
       Member findMember = memberRepository.findById(member.getId()).get();
       assertThat(findMember.getId()).isEqualTo(member.getId());
       assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
       assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
    }
}
