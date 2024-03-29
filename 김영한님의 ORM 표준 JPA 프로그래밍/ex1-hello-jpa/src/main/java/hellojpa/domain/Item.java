package hellojpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item {
  @Id
  @GeneratedValue
  @Column(name = "item_id")
  private Long id;
  private String name;
  private int price;
  private int stockQuantity;
}
