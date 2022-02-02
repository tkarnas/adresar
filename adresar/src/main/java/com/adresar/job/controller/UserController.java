package com.adresar.job.controller;

import com.adresar.job.model.User;
import com.adresar.job.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresar")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //get users
    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    //create user
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //search by phone number
    @PostMapping("/searchByPhoneNumber")
    public User searchByPhoneNumber(@RequestBody User user){
        List<User> users = userRepository.findAll();
        User userFound = null;

        for(User u: users){
            if(u.getPhoneNumber().equals(user.getPhoneNumber())){
                userFound = u;
            }
        }

        return userFound;
    }
    // search by Email
    @PostMapping("/searchByEmail")
    public User searchByEmail(@RequestBody User user){
        List<User> users = userRepository.findAll();
        User userFound = null;

        for(User u: users){
            if(u.getEmail().equals(user.getEmail())){
                userFound = u;
            }
        }

        return userFound;
    }

    //get one user by ID
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id) {
        User user = userRepository.findById(id).get();
        return ResponseEntity.ok().body(user);
    }

    //update user by ID
    @PutMapping("update/{id}")
    public String updateUser(@PathVariable(value = "id") Long id, @RequestBody User user){
        User updatedUser = userRepository.findById(id).get();
        User user1 = userRepository.findById(id).get();

        if(user.getPhoneNumber() != null){
            updatedUser.setPhoneNumber(user.getPhoneNumber());
        }
        if(user.getAddress() != null){
            updatedUser.setAddress(user.getAddress());
        }
        if(user.getEmail() != null){
            updatedUser.setEmail(user.getEmail());
        }

        userRepository.save(updatedUser);
        return "User " + updatedUser.getFirstName() + " " + updatedUser.getLastName() +" is updated!";
    }

    //delete user
    @DeleteMapping("delete/{id}")
    public HttpStatus deleteUser(@PathVariable(value = "id") Long id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return HttpStatus.OK;
    }

}
