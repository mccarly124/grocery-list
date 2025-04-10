package com.food.grocerylist_part2;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController // This means that this class is a Controller
@RequestMapping(path="/grocery")
public class BasicController {

    @Autowired
    private ItemRepository itemRepository;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(path="/post")
    public @ResponseBody String addNewTransaction(@RequestBody Item item){
        itemRepository.save(item);
        return "Added!";
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/get")
    public @ResponseBody Iterable<Item> getAllUsers() {
        // This returns a JSON or XML with the users
        return itemRepository.findAll();
    }

}

