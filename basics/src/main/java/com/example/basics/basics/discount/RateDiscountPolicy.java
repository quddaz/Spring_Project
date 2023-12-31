package com.example.basics.basics.discount;

import com.example.basics.basics.annotation.MainDiscountPolicy;
import com.example.basics.basics.member.Grade;
import com.example.basics.basics.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
  private  int discountPercent = 10;
  @Override
  public int discount(Member member, int price) {
    if(member.getGrade() == Grade.VIP){
      return price * discountPercent/100;
    }
    return 0;
  }
}
