package jpabook.jpashop.Member.item;

import jakarta.persistence.*;
import jpabook.jpashop.Member.catagory.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Not;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {
  @Id
  @GeneratedValue
  @Column(name = "item_id")
  private Long id;

  private String name;
  private int price;
  private int stockQuantity;

  @ManyToMany(mappedBy = "items")
  private List<Category> categories = new ArrayList<Category>();

  /**
   * 재고 수량 증가
   * @param quantity
   */
  public void addStock(int quantity){
    this.stockQuantity += quantity;
  }

  /**
   * 재고 수량 감소
   * @param quantity
   */
  public void removeStock(int quantity){
    int restStock = this.stockQuantity - quantity;
    if(restStock < 0){
      throw new NotEnoughStockException("need more stock");
    }
    this.stockQuantity = restStock;
  }
}
