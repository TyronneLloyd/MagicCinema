package za.ac.cput.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private String title;
    private String description;

    public Role() {};

    private Role(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
    }

    @Override
    public String toString() {
        return "Role Information \nID --> " + id + "\nTitle --> " + title + "\nDescription --> " + description;
    }

    public static class Builder {
        private int id;
        private String title, description;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Role build() {
            return new Role(this);
        }

        public Builder copy(Role role) {
            this.id = role.id;
            this.title = role.title;
            this.description = role.description;
            return this;
        }
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return  description;
    }
}
