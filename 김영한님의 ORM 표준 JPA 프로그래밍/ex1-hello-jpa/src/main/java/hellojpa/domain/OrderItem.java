package hellojpa.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
  @Id @GeneratedValue
  @Column(name = "order_item_id")
  private Long id;
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;
  @ManyToOne
  @JoinColumn(name = "item_id")
  private Item item;

  private int orderPrice;
  private int count;
}
