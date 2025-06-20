package core.generics;

import java.util.Objects;
import java.util.UUID;

public class Identity {
    private final String value;

    private Identity(String value) {
        this.value = value;
    }

    public static Identity of(String value) {
        String finalValue = (value == null || value.isEmpty())
                ? UUID.randomUUID().toString()
                : value;
        return new Identity(finalValue);
    }

    public static Identity random() {
        return new Identity(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Identity))
            return false;
        Identity other = (Identity) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
