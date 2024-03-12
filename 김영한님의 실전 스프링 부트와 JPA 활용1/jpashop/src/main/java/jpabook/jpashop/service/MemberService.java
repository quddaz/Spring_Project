package jpabook.jpashop.service;


import jpabook.jpashop.Member.member.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class MemberService {
  @Autowired
  private MemberRepository memberRepository;

  /**
   * 회원가입
   * @param member
   * @return
   */
  @Transactional
  public Long join(Member member){
    validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
  }

  /**
   * 중복 회원 검증
   * @param member
   */
  private void validateDuplicateMember(Member member) {
    List<Member> findMembers =
        memberRepository.findByName(member.getName());
    if (!findMembers.isEmpty()) {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    }
  }

  /**
   * 전체 회원 조회
   */
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }
  public Member findOne(Long memberId) {
    return memberRepository.findOne(memberId);
  }
}
