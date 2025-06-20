import core.domain.entity.User;
import core.domain.useCase.CreateUserUseCase;
import infra.database.repository.InMemoryUserRepository;

public class App {
    public static void main(String[] args) throws Exception {

        InMemoryUserRepository repository = new InMemoryUserRepository();
        CreateUserUseCase serviceUser = new CreateUserUseCase(repository);

        try {
            User user1 = serviceUser.execute("Ewerton", "ewerton@email.com", "ewerton123");
            System.out.println("Usuário criado: " + user1.getEmail());

            User user2 = serviceUser.execute("Ewerton", "ewerton@email.com", "ewerton123");
            System.out.println("Usuário criado: " + user2.getEmail());

        } catch (IllegalArgumentException e) {
            System.out.println("Error ao criar usuário: " + e.getMessage());
        }
    }
}
