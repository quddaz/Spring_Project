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
  private String username;
  private int age;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

}

