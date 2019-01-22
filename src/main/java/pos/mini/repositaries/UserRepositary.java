package pos.mini.repositaries;

import org.springframework.data.mongodb.repository.MongoRepository;
import pos.mini.models.Item;

public interface UserRepositary extends MongoRepository<Item, String> {

    public Item findByName(String Name);
    public Item findById(int id);
}