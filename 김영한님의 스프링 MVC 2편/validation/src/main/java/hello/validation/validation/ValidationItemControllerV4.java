package hello.validation.validation;


import hello.validation.domain.item.DTO.ItemSaveDTO;
import hello.validation.domain.item.DTO.ItemUpdateDTO;
import hello.validation.domain.item.Item;
import hello.validation.domain.item.ItemRepository;
import hello.validation.validation.group.SaveCheck;
import hello.validation.validation.group.UpdateCheck;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/validation/v4/items")
@RequiredArgsConstructor
public class ValidationItemControllerV4 {

    private final ItemRepository itemRepository;
    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "validation/v4/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable("itemId") long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v4/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "validation/v4/addForm";
    }

@PostMapping("/add")
public String addItemV6(@Validated @ModelAttribute("item") ItemSaveDTO itemSaveDTO, BindingResult
    bindingResult, RedirectAttributes redirectAttributes) {
    //특정 필드 예외가 아닌 전체 예외
    if (itemSaveDTO.getPrice() != null && itemSaveDTO.getQuantity() != null) {
        int resultPrice = itemSaveDTO.getPrice() * itemSaveDTO.getQuantity();
        if (resultPrice < 10000) {
            bindingResult.reject("totalPriceMin", new Object[]{10000,
                resultPrice}, null);
        }
    }
    if (bindingResult.hasErrors()) {
        log.info("errors={}", bindingResult);
        return "validation/v4/addForm";
    }
    //성공 로직
    Item item = new Item();
    item.set(itemSaveDTO.getItemName(),itemSaveDTO.getPrice(),itemSaveDTO.getQuantity());
    Item savedItem = itemRepository.save(item);
    redirectAttributes.addAttribute("itemId", savedItem.getId());
    redirectAttributes.addAttribute("status", true);
    return "redirect:/validation/v4/items/{itemId}";
}
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable("itemId") Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v4/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable("itemId") Long itemId, @Validated @ModelAttribute("item")ItemUpdateDTO itemUpdateDTO, BindingResult bindingResult) {
        //특정 필드 예외가 아닌 전체 예외
        if (itemUpdateDTO.getPrice() != null && itemUpdateDTO.getQuantity() != null) {
            int resultPrice = itemUpdateDTO.getPrice() * itemUpdateDTO.getQuantity();
            if (resultPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000,
                    resultPrice}, null);
            }
        }
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "validation/v4/editForm";
        }
        Item itemParam = new Item();
        itemParam.set(itemUpdateDTO.getItemName(),itemUpdateDTO.getPrice(),itemUpdateDTO.getQuantity());
        itemRepository.update(itemId, itemParam);
        return "redirect:/validation/v4/items/{itemId}";
    }

}



