package com.example.first.services;
import com.example.first.entity.User;
import com.example.first.REPO.UserRepo;

import com.example.first.exception.UserNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp implements UserServices {

    private final UserRepo userRepo;


    @Autowired
    public ServiceImp(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public User getUserbyId(int id){

        Optional <User> user = userRepo.findById(id);
        return user.orElseThrow(()->new UserNotFoundException("user not found"+id));
    }

    @Override
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }



    @Override
    public User updateUser( User user,int id){
        User existUser= userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User is not found!"));
        existUser.setName(user.getName());
        existUser.setAge(user.getAge());
        return userRepo.save(existUser);
        

    }

    @Override
    public void deleteUser(int id){
        userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User is not found with id"+id));
        userRepo.deleteById(id);
    }


}
