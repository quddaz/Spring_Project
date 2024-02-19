package hellojpa.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Member {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "USERNAME")
  private String name;
  @ManyToOne(fetch = FetchType.LAZY) //**
  @JoinColumn(name = "TEAM_ID")
  private Team team;
}

