package jpabook.jpashop.api.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateMemberResponse {
    private Long id;
    public CreateMemberResponse(Long id) {
        this.id = id;
    }
}