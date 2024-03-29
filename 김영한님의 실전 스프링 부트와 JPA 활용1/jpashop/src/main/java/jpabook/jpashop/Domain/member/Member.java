package jpabook.jpashop.Domain.member;

import jakarta.persistence.*;
import jpabook.jpashop.Domain.Address;
import jpabook.jpashop.Domain.order.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
  @Id
  @GeneratedValue
  @Column(name = "member_id")
  private Long id;

  private String name;

  @Embedded
  private Address address;

  @OneToMany(mappedBy = "member")
  private List<Order> orders = new ArrayList<>();
  @Builder
  public Member(String name){
    this.name = name;
  }
  public Member(){};

}
