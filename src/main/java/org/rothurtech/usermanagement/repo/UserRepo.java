package org.rothurtech.usermanagement.repo;

import org.rothurtech.usermanagement.model.User;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.Set;

@Repository
public class UserRepo {
    Set<User> users;

    public UserRepo() {
        this.users = new LinkedHashSet<>();
        User user1 = new User("a", "a", 18);
        User user2 = new User( "b", "b", 20);
        User user3 = new User("c", "c", 23);
        User user4 = new User("d", "d", 25);
        User user5 = new User("e", "e", 27);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    public User getUser(User userToFind) {
        for(User user : users){
            if(user.equals(userToFind)){
                return user;
            }
        }

        return null;
    }

    public Set<User> getAllUsers() {
        return users;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public boolean deleteUser(User user) {
        return users.remove(user);
    }
}
