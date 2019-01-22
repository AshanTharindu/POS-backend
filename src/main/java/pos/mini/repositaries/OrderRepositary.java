package pos.mini.repositaries;

import org.springframework.data.mongodb.repository.MongoRepository;
import pos.mini.models.Order;

public interface OrderRepositary extends MongoRepository<Order, String> {

    public Order findByUserId(int userId);
    public Order findById(int id);
}
