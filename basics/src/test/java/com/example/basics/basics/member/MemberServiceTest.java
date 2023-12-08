package com.example.basics.basics.member;

import com.example.basics.basics.AppConfig;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {
  MemberService memberService;
  @BeforeEach
  void before(){
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    applicationContext.getBean("memberService", MemberService.class);
  }
  @Test
  @DisplayName("회원가입 테스트")
  void join(){
    //given
    Member member = new Member(1L,"memberA",Grade.VIP);
    //when
    memberService.join(member);
    Member findMember = memberService.findMember(1L);
    //then
    Assertions.assertThat(member).isEqualTo(findMember);
  }
}
