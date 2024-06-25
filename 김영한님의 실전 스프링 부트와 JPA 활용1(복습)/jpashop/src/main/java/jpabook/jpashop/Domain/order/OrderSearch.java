package jpabook.jpashop.Domain.order;

import jpabook.jpashop.Domain.order.Enum.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
  private String memberName;
  private OrderStatus orderStatus;
}
