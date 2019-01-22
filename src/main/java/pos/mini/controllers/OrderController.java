package pos.mini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pos.mini.models.Order;
import pos.mini.repositaries.OrderRepositary;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderRepositary orderRepositary;

    @PostMapping("/newOrder/{userId}")
    public ResponseEntity<?> newOrder(@PathVariable int userId) {
        System.out.println(userId);
        Order order = orderRepositary.save(new Order(userId));
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
