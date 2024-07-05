package com.example.Associates.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "application_user")
public class ApplicationUser {
    private final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String email;
    private String password;
    private String role;

    public ApplicationUser() {
    }

    private ApplicationUser(ApplicationUserBuilder applicationUserBuilder) {
        this.username = applicationUserBuilder.username;
        this.email = applicationUserBuilder.email;
        this.password = applicationUserBuilder.password;
        this.role = applicationUserBuilder.role;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public static class ApplicationUserBuilder {
        private String username;
        private String email;
        private String password;
        private String role;

        public ApplicationUserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public ApplicationUserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ApplicationUserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public ApplicationUserBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public ApplicationUser build() {
            return new ApplicationUser(this);
        }
    }
}
