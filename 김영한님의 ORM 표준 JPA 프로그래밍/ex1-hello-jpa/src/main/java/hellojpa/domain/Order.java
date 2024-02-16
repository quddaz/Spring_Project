package hellojpa.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "ORDERS")
public class Order {
  @Id @GeneratedValue
  @Column(name = "order_id")
  private Long id;
  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  private LocalDateTime orderDate;
  @Enumerated(EnumType.STRING)
  private OrderStatus status;
}

