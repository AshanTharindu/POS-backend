package pos.mini.repositaries;

import org.springframework.data.mongodb.repository.MongoRepository;
import pos.mini.models.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
    public User findById(int id);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
