package pos.mini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pos.mini.models.Item;
import pos.mini.models.ItemTracker;
import pos.mini.models.Order;
import pos.mini.repositaries.ItemRepository;
import pos.mini.repositaries.OrderRepository;

import java.util.HashMap;
import java.util.List;
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
        //update order
        System.out.println(orderId);
        System.out.println(itemId);
        System.out.println(count);
        Map<String, Double> updateOrder = updateOrder(order, itemId, count);
        return new ResponseEntity<Map<String,Double>>(updateOrder, HttpStatus.OK);
    }

    public Map<String, Double> updateOrder(Order order, int itemId, int count) {
        List<ItemTracker> itemTrackerList = order.getItemList();
        ItemTracker updatedItemTracker = null;
        for(ItemTracker itemTracker: itemTrackerList) {
            if(itemTracker.getItemId() == itemId) {
                updatedItemTracker = itemTracker;
            }
        }
        double subTotal = 0;
        double updatedSubTotal = 0;
        if(updatedItemTracker != null) {
            subTotal = updatedItemTracker.getSubTotal();
            updatedSubTotal = updatedItemTracker.getPrice()* count;
        }
        Map<String, Double> updatedValues = new HashMap<>();
        updatedValues.put("subTotal", updatedSubTotal);
        double total = order.getTotal() - subTotal + updatedSubTotal;
        updatedValues.put("total", total);
        return updatedValues;
    }

    //save order
}
