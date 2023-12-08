package com.example.basics.basics.OrderTest;

import com.example.basics.basics.AppConfig;
import com.example.basics.basics.member.Grade;
import com.example.basics.basics.member.Member;
import com.example.basics.basics.member.MemberService;
import com.example.basics.basics.member.MemberServiceImpl;
import com.example.basics.basics.order.OrderServiceImpl;
import com.example.basics.basics.order.Order;
import com.example.basics.basics.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrderServiceTest {
  private MemberService memberService;
  private OrderService orderService;
  @BeforeEach
  void before(){
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    memberService = applicationContext.getBean("memberService", MemberService.class);
    orderService = applicationContext.getBean("orderService", OrderService.class);
  }
  @Test
  @DisplayName("오더 서비스 테스트")
  void Order(){
    //given
    Long memberId = 1L;
    Member member = new Member(memberId,"memberA", Grade.VIP);
    //when
    memberService.join(member);
    Order order = orderService.createOrder(memberId, "itemA", 10000);
    //then
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}
