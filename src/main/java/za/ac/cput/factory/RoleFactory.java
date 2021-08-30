package za.ac.cput.factory;

import za.ac.cput.entity.Role;

public class RoleFactory {
    public static Role createRole(String title, String description) {

        Role role = new Role.Builder()
                .setTitle(title)
                .setDescription(description)
                .build();

        return role;

    }
}
