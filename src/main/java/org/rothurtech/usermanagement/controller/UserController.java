package org.rothurtech.usermanagement.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.juli.logging.LogFactory;
import org.rothurtech.usermanagement.exception.UserException;
import org.rothurtech.usermanagement.model.User;
import org.rothurtech.usermanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;


//swagger-ui annotation
@Tag(name = "User Management System", description = "Tutorial management APIs")
@RestController("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public String getUser(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());
        }

        User userRes = userService.getUser(user);

        if(userRes == null){
            return "User" + user +  " not exists!";
        }else{
            return "User" + user +  " exists!";
        }
    }

    @GetMapping("/getAllUsers")
    public Set<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> updateUser(@RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());
        }
        if(userService.getUser(user) != null) {
            logger.info("User {} already exists!", user);
            return new ResponseEntity<>("User already exists!", HttpStatus.ALREADY_REPORTED);
        }else{
            if(userService.addUser(user)) {
                logger.info("User {} added successfully!", user);
                return new ResponseEntity<>("User added!", HttpStatus.CREATED);
            }

        }

        return new ResponseEntity<>("User added failed!", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @DeleteMapping("/deleteUser")
    @ResponseBody
    public ResponseEntity<String> deleteUser(@RequestBody User user) {
        if(userService.getUser(user) == null) {
            return new ResponseEntity<>("No existing user found!", HttpStatus.NO_CONTENT);
        }else{
            if(userService.deleteUser(user)) {
                return new ResponseEntity<>("User" + user + " deleted!", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("User deleted failed!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/errortest")
    public ResponseEntity<String> errorTest() {
        throw new UserException("I am user exception!");
    }

}
