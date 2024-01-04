package MyAPI.MyAPI.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  private String name;
  private Long age;
  @Builder //빌더 패턴
  public Member(String name, Long age) {
    this.name = name;
    this.age = age;
  }

  public Member() {

  }
}
