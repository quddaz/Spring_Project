package hello.servlet.basic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class HelloData {
  private String username;
  private int age;

  @JsonCreator
  @Builder
  public HelloData(@JsonProperty("username") String username, @JsonProperty("age") int age) {
    this.username = username;
    this.age = age;
  }
  public HelloData(){

  }
}
