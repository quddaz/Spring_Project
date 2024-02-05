package com.example.basics.basics.AppConfigTest;

import com.example.basics.basics.AutoAppConfig;
import com.example.basics.basics.member.MemberService;
import com.example.basics.basics.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
  @Test
  void basicScan() {
    ApplicationContext ac = new
        AnnotationConfigApplicationContext(AutoAppConfig.class);
    MemberService memberService = ac.getBean(MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
  }
}
