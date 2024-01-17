package hello.itemservice.domain.DTO;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateParamItemDTO {
  private String itemName;
  private Integer price;
  private Integer quantity;
  @Builder
  public UpdateParamItemDTO(String itemName, Integer price, Integer quantity) {
    this.itemName = itemName;
    this.price = price;
    this.quantity = quantity;
  }
}
