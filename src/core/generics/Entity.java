package core.generics;

public class Entity<T> {
    private Identity valueId;
    protected T properties;

    protected Entity(T properties, Identity valueId) {
        this.properties = properties;
        this.valueId = valueId != null ? valueId : Identity.random();
    }

    public static <T> Entity<T> of(T properties, Identity valueId) {
        return new Entity<>(properties, valueId);
    }

    public static <T> Entity<T> create(T properties) {
        return new Entity<>(properties, null);
    }

    public Identity getId() {
        return valueId;
    }
}
