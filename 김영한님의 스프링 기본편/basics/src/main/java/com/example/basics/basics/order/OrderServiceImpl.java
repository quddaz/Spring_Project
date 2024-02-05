package com.example.basics.basics.order;

import com.example.basics.basics.annotation.MainDiscountPolicy;
import com.example.basics.basics.discount.DiscountPolicy;
import com.example.basics.basics.member.Member;
import com.example.basics.basics.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPoilcy;
  @Autowired
  public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPoilcy) {
    this.memberRepository = memberRepository;
    this.discountPoilcy = discountPoilcy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPoilcy.discount(member, itemPrice);
    return  new Order(memberId, itemName, itemPrice,discountPrice);
  }
}
