package hellojpa.domain;

import hellojpa.domain.ValueType.Address;
import hellojpa.domain.ValueType.Period;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Member {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "USERNAME")
  private String name;
  @Embedded
  private Period workPeriod;

  @Embedded
  private Address homeAddress;
  @ElementCollection
  @CollectionTable(name = "favorite_food", joinColumns =
  @JoinColumn(name = "member_id"))
  private Set<String> favoriteFoods = new HashSet<>();

  @ElementCollection
  @CollectionTable(name = "address",joinColumns = @JoinColumn(name = "member_id"))
  private List<Address> addressHistory = new ArrayList<>();
}

