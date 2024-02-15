package hellojpa.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Member {
  @Id
  @GeneratedValue()
  @Column(name = "member_id")
  private Long id;
  private String name;
  private String city;
  private String street;
  private String zipcode;
}
