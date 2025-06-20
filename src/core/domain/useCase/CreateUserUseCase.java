package core.domain.useCase;

import core.domain.repository.UserRepository;
import core.domain.entity.User;
import core.domain.entity.type.PropsUser;

public class CreateUserUseCase {
    private final UserRepository<User> userRepository;

    public CreateUserUseCase(UserRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String name, String email, String password) {
        User emailExist = userRepository.findByEmail(email);
        if (emailExist != null) {
            throw new IllegalArgumentException("Email ja cadastrado.");
        }
        PropsUser props = new PropsUser(name, email, password);
        User newUser = User.create(props);
        userRepository.create(newUser);
        return newUser;
    }
}
