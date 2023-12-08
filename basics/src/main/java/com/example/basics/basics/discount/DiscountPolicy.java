package com.example.basics.basics.discount;

import com.example.basics.basics.member.Member;

public interface DiscountPolicy {
  /**
   * 할인 해주는 메소드
   *
   * @param  member 할인 맴버
   * @param  price 구매 금액
   * @return 할인 대상 금액
   */
  int discount(Member member, int price);
}
