package com.food.grocerylist_part2;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/list")
public class BasicController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewTransaction(@RequestParam String name, @RequestParam String store, @RequestParam String category, @RequestParam Float price, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        Item n = new Item();
        n.setCategory(category);
        n.setDate(date);
        n.setName(name);
        n.setPrice(price);
        n.setStore(store);
        itemRepository.save(n);
        return "Added!";
    }

    @GetMapping("/grocery")
    public @ResponseBody Iterable<Item> getAllUsers() {
        // This returns a JSON or XML with the users
        return itemRepository.findAll();
    }

}

