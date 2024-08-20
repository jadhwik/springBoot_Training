package com.example.first.services;
import com.example.first.entity.User;
import java.util.List;
public interface UserServices {

    public User getUserbyId(int id);
    List<User> getAllUsers();

    public User createUser(User user);

    public User updateUser( User user,int id);
    public void deleteUser(int id);


}
