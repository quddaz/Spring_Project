package com.example.basics.basics.member;


public interface MemberRepository {
  void save(Member member);
  Member findById(Long memberId);
}
