package com.example.basics.basics.member;

public class MemberServiceImpl implements  MemberService{

  //해당 코드는 추상화와 구체화 모두에게 의존하고 있다.
  private MemberRepository memberRepository;

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /*
   * 회원가입하는 메소드
   * @param member
   */
  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }
/*
 * 맴버를 조회하는 메소드
 * @param Long memberId 찾으려는 맴버 객체의 기본키
 * @return Member
 */
  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
