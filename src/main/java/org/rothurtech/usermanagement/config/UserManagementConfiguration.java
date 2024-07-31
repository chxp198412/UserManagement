package org.rothurtech.usermanagement.config;

import org.rothurtech.usermanagement.dao.UserDao;
import org.rothurtech.usermanagement.repo.UserRepo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserManagementConfiguration {
    @Bean
    public UserDao getUserDao(UserRepo userRepo){
        return new UserDao(userRepo);
    }
}
