package hellojpa.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ORDERS")
public class Order {
  @Id @GeneratedValue
  @Column(name = "order_id")
  private Long id;
  @Column(name = "member_id")
  private Long memberId;
  private LocalDateTime orderDate;
  @Enumerated(EnumType.STRING)
  private OrderStatus status;
}
