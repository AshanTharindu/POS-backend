package pos.mini.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
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

        //remove later
        System.out.println(orderId);
        System.out.println(itemId);
        System.out.println(count);

        //update order
//        Map<String, String> updateOrder = updateOrder(order, itemId, count);
        order = updateOrder(order, itemId, count);
        orderRepository.save(order);

        System.out.println("after update");
        for(Order order1: orderRepository.findAll()){
            System.out.println( "orderID: " +order1.getId());
            System.out.println("orderTotal: " +order1.getTotal());
        }
//        return new ResponseEntity<Map<String,String>>(updateOrder, HttpStatus.OK);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    //update order logic
    public Order updateOrder(Order order, int itemId, int count) {
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
            System.out.println("subtotal: " + subTotal);
            updatedSubTotal = updatedItemTracker.getPrice()* count;
            System.out.println("updateSub: " + updatedSubTotal);
        }

        double total = order.getTotal() - subTotal + updatedSubTotal;
        Order orderTrackerUpdated = updateItemTracker(order, itemId, count);
        orderTrackerUpdated.setTotal(total);

        //returning map containing total & subtotal
//
//        Map<String, String> updatedValues = new HashMap<>();
//        updatedValues.put("itemId", String.valueOf(itemId));
//        updatedValues.put("subTotal", String.valueOf(updatedSubTotal));
//        double total = order.getTotal() - subTotal + updatedSubTotal;
//        updatedValues.put("total", String.valueOf(total));
//        return updatedValues;

        return order;
    }

    //update item tracker
    public Order updateItemTracker(Order order, int itemId, int count) {
        List<ItemTracker> itemList = order.getItemList();
        for(ItemTracker itemTracker: itemList) {
            if(itemTracker.getItemId() == itemId) {
                itemTracker.setCount(count);
            }
        }
        order.setItemList(itemList);
        return order;
    }

    //save order
}
