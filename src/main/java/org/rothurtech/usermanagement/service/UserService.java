package org.rothurtech.usermanagement.service;

import org.rothurtech.usermanagement.dao.UserDao;
import org.rothurtech.usermanagement.model.User;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(User user) {
//        if(userCache.get(user.hashCode()) == null){
//            if(userDao.getUser(user) != null){
//                userCache.put(user.hashCode(), user);
//                return user;
//            }
//        }
//
//        return null;

        return userDao.getUser(user);
    }

    public Set<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public boolean deleteUser(User user) {
        return userDao.deleteUser(user);
    }


}
