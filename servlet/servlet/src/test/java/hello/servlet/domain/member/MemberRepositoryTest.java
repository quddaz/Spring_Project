package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryTest {
  MemberRepository memberRepository = MemberRepository.getInstance();
  @AfterEach
  void afterEach(){
    memberRepository.clearStore();
  }
  @Test
  @DisplayName("회원 저장 테스트")
  void save(){
    //given
    Member member= new Member("hello", 20);
    //when
    Member savedMember = memberRepository.save(member);
    //then
    Member findMember = memberRepository.findById(savedMember.getId());
    Assertions.assertThat(findMember).isEqualTo(savedMember);
  }
  @Test
  @DisplayName("회원 전체 찾기 테스트")
  void findAll(){
    //given
    Member member1 = new Member("member", 20);
    Member member2 = new Member("member2", 30);
    memberRepository.save(member1);
    memberRepository.save(member2);
    //when
    List<Member> result = memberRepository.findAll();
    //then
    Assertions.assertThat(result.size()).isEqualTo(2);
    Assertions.assertThat(result).contains(member1,member2);
  }

}
