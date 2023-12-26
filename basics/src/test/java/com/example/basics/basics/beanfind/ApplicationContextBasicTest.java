package com.example.basics.basics.beanfind;

import com.example.basics.basics.AppConfig;
import com.example.basics.basics.member.MemberService;
import com.example.basics.basics.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 이름으로 조회")
  void findBeanByName() {
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }
  @Test
  @DisplayName("이름 없이 타임으로 조회")
  void findBeanByType() {
    MemberService memberService = ac.getBean(MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }
  @Test
  @DisplayName("구체 타입으로 조회")
  void findBeanByType2() {
    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }
  @Test
  @DisplayName("빈 이름으로 조회X")
  void findBeanByNameX(){
    MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
    org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()-> ac.getBean("XXXXX", MemberService.class));

  }
}
