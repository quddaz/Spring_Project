package jpabook.jpashop.Member.order;

import jakarta.persistence.*;
import jpabook.jpashop.Member.member.Member;
import jpabook.jpashop.Member.OrderItem;
import jpabook.jpashop.Member.order.Enum.DeliveryStatus;
import jpabook.jpashop.Member.order.Enum.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue
  @Column(name = "order_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
  private List<OrderItem> orderItems = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "delivery_id")
  private Delivery delivery;

  private LocalDateTime orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  public void setMember(Member member) {
    this.member = member;
    member.getOrders().add(this);
  }
  public void addOrderItem(OrderItem orderItem) {
    orderItems.add(orderItem);
    orderItem.setOrder(this);
  }
  public void setDelivery(Delivery delivery) {
    this.delivery = delivery;
    delivery.setOrder(this);
  }

  //==생성 메서드==//
  @Builder
  public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
    Order order = new Order();
    order.setMember(member);
    order.setDelivery(delivery);
    for (OrderItem orderItem : orderItems) {
      order.addOrderItem(orderItem);
    };
    order.setOrderStatus(OrderStatus.ORDER);
    order.setOrderDate(LocalDateTime.now());
    return order;
  }

  /**
   * 상품 주문 취소 로직
   */
  public void cancel(){
    if(delivery.getStatus() == DeliveryStatus.COMP){
      throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
    }
    this.setOrderStatus(OrderStatus.CANCEL);
    for(OrderItem orderItem : orderItems){
      orderItem.cancel();
    }
  }

  //==조회 로직==/

  /**
   * 전체 주문 가격 조회
   * @return
   */
  public int getTotalPrice(){
    return orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();
  }
}
