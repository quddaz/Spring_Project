package jpabook.jpashop.Member.order;

import jpabook.jpashop.Member.order.Enum.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
  private String memberName;
  private OrderStatus orderStatus;
}
