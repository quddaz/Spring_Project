package jpabook.jpashop.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Result<T> {
    private T data;
}