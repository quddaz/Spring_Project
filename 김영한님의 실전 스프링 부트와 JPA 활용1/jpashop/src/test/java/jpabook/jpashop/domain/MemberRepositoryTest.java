package jpabook.jpashop.domain;

import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MemberRepositoryTest {
  @Autowired
  MemberRepository memberRepository;
  @Test
  @Transactional
  public void testMember() {
    Member member = new Member();
    member.setUsername("memberA");
    Long savedId = memberRepository.save(member);
    Member findMember = memberRepository.find(savedId);
    Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());

    Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
    Assertions.assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
  }
}