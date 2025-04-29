package ru.netology.authorizationservice;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static final List<User> USERS = List.of(
            new User("admin", "admin123", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)),
            new User("user", "password", List.of(Authorities.READ))
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (User u : USERS) {
            if (u.getUsername().equals(user) && u.getPassword().equals(password)) {
                return u.getAuthorities();
            }
        }
        return new ArrayList<>();
    }

    private static class User {
        private final String username;
        private final String password;
        private final List<Authorities> authorities;

        public User(String username, String password, List<Authorities> authorities) {
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public List<Authorities> getAuthorities() {
            return authorities;
        }
    }
}
