package hello.itemservice.controller;

import hello.itemservice.domain.DTO.UpdateParamItemDTO;
import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
  private final ItemRepository itemRepository;

  @GetMapping
  public String items(Model model){
    List<Item> item = itemRepository.findAll();
    model.addAttribute("items",item);
    return "basic/items";
  }
  @GetMapping("/{itemId}")
  public String item(@PathVariable(name = "itemId") long itemId, Model model){
    Item item = itemRepository.findById(itemId);
    model.addAttribute("item", item);
    return "basic/item";
  }
  @GetMapping("/add")
  public String addForm(){
    return "basic/addForm";
  }
  @PostMapping("/add")
  public String save(@ModelAttribute Item item, RedirectAttributes redirectAttributes){
    Item savedItem = itemRepository.save(item);
    redirectAttributes.addAttribute("itemId", savedItem.getId());
    redirectAttributes.addAttribute("status", true);
    //@ModelAttribute는 자동으로 다음 폼에 item을 넘겨준다.
    return "redirect:/basic/items";
  }
  @GetMapping("/{itemId}/edit")
  public String editForm(@PathVariable(name = "itemId") long itemId, Model model){
    Item item = itemRepository.findById(itemId);
    model.addAttribute("item",item);
    return "/basic/editForm";
  }
  @PostMapping("/{itemId}/edit")
  public String edit(@PathVariable(name = "itemId") long itemId, @ModelAttribute Item item) {
    UpdateParamItemDTO updateParamItemDTO = new UpdateParamItemDTO(item.getItemName(), item.getPrice(), item.getQuantity());
    itemRepository.update(itemId, updateParamItemDTO);
    return "redirect:/basic/items/{itemId}";
  }
  @PostConstruct
  public  void init(){
    itemRepository.save(new Item("testA", 10000, 10));
    itemRepository.save(new Item("testB", 20000, 20));
  }
}
