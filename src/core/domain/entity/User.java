package core.domain.entity;

import core.generics.Entity;
import core.generics.Identity;
import core.domain.entity.type.PropsUser;

public class User extends Entity<PropsUser> {
    private User(PropsUser props, Identity id) {
        super(props, id);
    }

    public static User of(PropsUser props, Identity id) {
        return new User(props, id);
    }

    public static User create(PropsUser props) {
        return new User(props, null);
    }

    public String getName() {
        return this.properties.getName();
    }

    public String getEmail() {
        return this.properties.getEmail();
    }

    public void updateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.properties.setName(name);
    }

    public void updateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        this.properties.setEmail(email);
    }

}
