package jpabook.jpashop.service;

import jpabook.jpashop.Domain.orderItem.OrderItem;
import jpabook.jpashop.Domain.item.Item;
import jpabook.jpashop.Domain.member.Member;
import jpabook.jpashop.Domain.order.Delivery;
import jpabook.jpashop.Domain.order.Enum.DeliveryStatus;
import jpabook.jpashop.Domain.order.Order;
import jpabook.jpashop.Domain.order.OrderSearch;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
  private final OrderRepository orderRepository;
  private final MemberRepository memberRepository;
  private final ItemRepository itemRepository;

  /**
   * 주문
   * @param memberId
   * @param itemId
   * @param count
   * @return
   */
  @Transactional
  public Long order(Long memberId, Long itemId, int count){
    //엔티티 조회
    Member member = memberRepository.findOne(memberId);
    Item item = itemRepository.findOne(itemId);
    //배송정보 생성
    Delivery delivery = new Delivery();
    delivery.setAddress(member.getAddress());
    delivery.setStatus(DeliveryStatus.READY);
    //주문상품 생성
    OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
    //주문 생성
    Order order = Order.createOrder(member, delivery, orderItem);
    //주문 저장
    orderRepository.save(order);
    return order.getId();
  }

  /**
   * 주문 취소
   * @param orderId
   */
  @Transactional
  public void cancelOrder(Long orderId){
    Order order = orderRepository.findOne(orderId);
    order.cancel();
  }
  public List<Order> findOrders(OrderSearch orderSearch) {
    return orderRepository.findAll(orderSearch);
  }

}
