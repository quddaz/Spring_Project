package com.example.basics.basics;

import com.example.basics.basics.discount.RateDiscountPolicy;
import com.example.basics.basics.member.Grade;
import com.example.basics.basics.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {
  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP는 10%할인 적용")
  void vip_o(){
    //given
    Member member = new Member(1L,"memberVIP", Grade.VIP);
    //when
    int discount = discountPolicy.discount(member,10000);
    //then
    assertThat(discount).isEqualTo(1000);
  }
  @Test
  @DisplayName("VIP가 아닌경우 할인이 적용되지 않아야 한다.")
  void vip_x(){
    //given
    Member member = new Member(1L,"memberVIP", Grade.BASIC);
    //when
    int discount = discountPolicy.discount(member,10000);
    //then
    assertThat(discount).isEqualTo(0);
  }

}
