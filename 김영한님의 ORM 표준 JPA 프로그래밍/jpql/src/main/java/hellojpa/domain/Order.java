package hellojpa.domain;

import hellojpa.domain.ValueType.Address;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ORDERS")
public class Order {
  @Id @GeneratedValue
  private Long id;

  private int orderAmount;
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
  @Embedded
  private Address address;

}

