package org.avishek.schedular;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserRegistration {
    private Repo repo;

    public void register(User user) {
        repo.registerUser(user);
    }
}
