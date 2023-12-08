package com.example.basics.basics.member;


import lombok.Builder;
import lombok.Data;

@Data
public class Member {

  private Long id;
  private String name;
  private Grade grade;

  public Member(Long id, String name, Grade grade){
    this.id = id;
    this.name = name;
    this.grade = grade;
  }


}
