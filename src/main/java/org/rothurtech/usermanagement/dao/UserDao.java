package org.rothurtech.usermanagement.dao;

import org.rothurtech.usermanagement.model.User;
import org.rothurtech.usermanagement.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserDao {

    //how to DI?
    private final UserRepo userRepo;

    public UserDao(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUser(User user) {
        return userRepo.getUser(user);
    }

    public Set<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public boolean addUser(User user) {
        return userRepo.addUser(user);
    }

    public boolean deleteUser(User user) {
        return userRepo.deleteUser(user);
    }
}
