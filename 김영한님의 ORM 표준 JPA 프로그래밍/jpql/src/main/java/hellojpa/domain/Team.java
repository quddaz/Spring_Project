package hellojpa.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Team {
  @Id @GeneratedValue
  @Column(name = "team_id")
  private Long id;
  private String name;
  @OneToMany(mappedBy = "team")
  private List<Member> members = new ArrayList<>();
}
