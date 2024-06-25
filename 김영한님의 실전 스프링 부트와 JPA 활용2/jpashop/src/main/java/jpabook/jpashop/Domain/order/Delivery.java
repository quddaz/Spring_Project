package jpabook.jpashop.Domain.order;

import jakarta.persistence.*;
import jpabook.jpashop.Domain.Address;
import jpabook.jpashop.Domain.order.Enum.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {
  @Id
  @GeneratedValue
  @Column(name = "delivery_id")
  private Long id;

  @OneToOne(mappedBy = "delivery")
  private Order order;

  @Embedded
  private Address address;

  @Enumerated(EnumType.STRING)
  private DeliveryStatus status;
}
