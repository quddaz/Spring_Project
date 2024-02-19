package hellojpa.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Child {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Parent parent;
}
