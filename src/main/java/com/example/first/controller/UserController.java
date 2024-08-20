package com.example.first.controller;
import com.example.first.services.ServiceImp;
import com.example.first.entity.User;


import lombok.Generated;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    private final ServiceImp serviceImp;

    @Autowired
    public UserController(ServiceImp serviceImp){
       this.serviceImp=serviceImp;
    }

    @PostMapping
    public User createUser( @RequestBody User user){

        return serviceImp.createUser(user);

    }

    @GetMapping("/all")
    public List<User> getAllUsers(User user){
        return serviceImp.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUserbyId(@PathVariable int id){
        return serviceImp.getUserbyId(id);
    }

    @PutMapping("{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id){

        return serviceImp.updateUser(user,id);

    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable int id){
        serviceImp.deleteUser(id);
    }



}
