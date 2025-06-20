package core.domain.repository;

public abstract class UserRepository<T> {
    public abstract T create(T entity);

    public abstract T findById(String id);

    public abstract T findByEmail(String email);
}
