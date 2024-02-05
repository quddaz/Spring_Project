package com.example.basics.basics;

import com.example.basics.basics.discount.DiscountPolicy;
import com.example.basics.basics.discount.FixDiscountPolicy;
import com.example.basics.basics.discount.RateDiscountPolicy;
import com.example.basics.basics.member.MemberRepository;
import com.example.basics.basics.member.MemberService;
import com.example.basics.basics.member.MemberServiceImpl;
import com.example.basics.basics.member.MemoryMemberRepository;
import com.example.basics.basics.order.OrderServiceImpl;
import com.example.basics.basics.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public MemberService memberService(){
    return new MemberServiceImpl(memberRepository());
  }
  @Bean
  public OrderService orderService(){
    return  new OrderServiceImpl(memberRepository(),discountPolicy());
  }
  /**
   *MemberRepository 구현
   *
   */
  @Bean
  public MemberRepository memberRepository(){
    return new MemoryMemberRepository();
  }
  /**
   *DiscountPolicy 구현
   *
   */
  @Bean
  public DiscountPolicy discountPolicy(){
    return new RateDiscountPolicy();
  }
}
