package infra.database.repository;

import java.util.HashMap;
import java.util.Map;

import core.domain.entity.User;
import core.domain.repository.UserRepository;

public class InMemoryUserRepository extends UserRepository<User> {
    public final Map<String, User> database = new HashMap<>();

    @Override
    public User create(User entity) {
        database.put(entity.getId().toString(), entity);
        return entity;
    }

    @Override
    public User findById(String id) {
        User user = database.get(id);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return database.values()
                .stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}
