package com.example.basics.basics.Autowired.allBean;

import com.example.basics.basics.AutoAppConfig;
import com.example.basics.basics.discount.DiscountPolicy;
import com.example.basics.basics.member.Grade;
import com.example.basics.basics.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class allBeanTest {
  @Test
  @DisplayName("모든 빈을 찾음")
  void findAllBean(){
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
    DiscountService discountService = ac.getBean(DiscountService.class);
    Member member = new Member(1L, "userA", Grade.VIP);
    int discountPrice = discountService.discount(member,10000,"fixDiscountPolicy");
    Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
    Assertions.assertThat(discountPrice).isEqualTo(1000);
  }
  @Component
  static class DiscountService{
    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policies;
    @Autowired
    public DiscountService(Map<String, DiscountPolicy> policyMap,
                           List<DiscountPolicy> policies) {
      this.policyMap = policyMap;
      this.policies = policies;
      System.out.println("policyMap = " + policyMap);
      System.out.println("policies = " + policies);
    }
    public int discount(Member member, int price, String discountCode) {
      DiscountPolicy discountPolicy = policyMap.get(discountCode);
      System.out.println("discountCode = " + discountCode);
      System.out.println("discountPolicy = " + discountPolicy);
      return discountPolicy.discount(member, price);
    }
  }
}
