package pos.mini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pos.mini.models.Item;
import pos.mini.models.Order;
import pos.mini.repositaries.ItemRepository;
import pos.mini.repositaries.OrderRepository;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Order order) {
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?>update(@RequestBody Map<String ,Integer> updateObject) {
        int orderId = updateObject.get("orderId");
        int itemId = updateObject.get("itemId");
        int count = updateObject.get("count");
        Order order = orderRepository.findById(orderId);
        Item item = itemRepository.findById(itemId);
        //update order
        System.out.println(orderId);
        System.out.println(itemId);
        System.out.println(count);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    //save order
}
