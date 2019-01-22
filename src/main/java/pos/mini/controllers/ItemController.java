package pos.mini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pos.mini.models.Item;
import pos.mini.repositaries.ItemRepositary;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepositary itemRepositary;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/showItems")
    public ResponseEntity<List<Item>> showOrders() {
        List<Item> items = itemRepositary.findAll();
        for(Item item: items) {
            System.out.println(item.getName());
        }
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }
}
