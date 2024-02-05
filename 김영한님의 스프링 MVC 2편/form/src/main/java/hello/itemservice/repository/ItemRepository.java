package hello.itemservice.repository;

import hello.itemservice.domain.DTO.UpdateParamItemDTO;
import hello.itemservice.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
  private static final Map<Long, Item> store = new HashMap<>();
  private static long squence= 0L;

  public Item save(Item item){
    item.setId(++squence);
    store.put(item.getId(),item);
    return item;
  }

  public Item findById(Long id){
    return store.get(id);
  }
  public List<Item> findAll(){
    return new ArrayList<>(store.values());
  }
  public void update(Long itemId, UpdateParamItemDTO updateParamItemDTO){
    Item findItem = findById(itemId);
    findItem.setItemName(updateParamItemDTO.getItemName());
    findItem.setPrice(updateParamItemDTO.getPrice());
    findItem.setQuantity(updateParamItemDTO.getQuantity());
  }
  public void clearStore() {
    store.clear();
  }
}
