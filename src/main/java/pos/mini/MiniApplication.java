package pos.mini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pos.mini.models.Item;
import pos.mini.models.ItemTracker;
import pos.mini.models.Order;
import pos.mini.repositaries.ItemRepository;
import pos.mini.repositaries.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MiniApplication implements CommandLineRunner {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(MiniApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();
        orderRepository.deleteAll();
        // save a couple of customers
        Item burger = repository.save(new Item("Burger", 50.0));
        Item coke = repository.save(new Item("Coke", 35.0));

        System.out.println("itemId: " + burger.getId());
        System.out.println("itemId: " + coke.getId());

        ItemTracker itemTracker1 = new ItemTracker(1);
        itemTracker1.setPrice(burger.getPrice());
        itemTracker1.setCount(3);
        Order order = new Order(1);

        ItemTracker itemTracker2 = new ItemTracker(2);
        itemTracker2.setPrice(coke.getPrice());
        itemTracker2.setCount(2);


        List<ItemTracker> itemList = new ArrayList<>();
        itemList.add(itemTracker1);
        itemList.add(itemTracker2);
        order.setItemList(itemList);

        order.setTotal(50.0 * 3 + 35 *2);

        orderRepository.save(order);

        Order order2 = new Order(2);


//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (Customer customer : repository.findAll()) {
//            System.out.println(customer);
//        }
//        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByFirstName("Alice"));
//
//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (Customer customer : repository.findByLastName("Smith")) {
//            System.out.println(customer);
//        }

        for(Order order1: orderRepository.findAll()){
            System.out.println( "orderID: " +order1.getId());
            System.out.println("orderTotal: " +order1.getTotal());
        }

    }

}
