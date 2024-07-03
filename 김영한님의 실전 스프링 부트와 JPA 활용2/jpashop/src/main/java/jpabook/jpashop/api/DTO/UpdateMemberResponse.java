package jpabook.jpashop.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class UpdateMemberResponse {
    private Long id;
    private String name;
}