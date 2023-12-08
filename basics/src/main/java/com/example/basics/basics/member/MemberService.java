package com.example.basics.basics.member;

public interface MemberService {
  void join(Member member);
  Member findMember(Long memberId);
}
