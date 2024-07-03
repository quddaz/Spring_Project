package jpabook.jpashop.api.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateMemberRequest {
    private String name;
}