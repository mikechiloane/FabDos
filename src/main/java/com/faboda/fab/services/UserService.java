package com.faboda.fab.services;

import com.faboda.fab.model.User;
import com.faboda.fab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String registerUser(User user){
        if(userExists(user.getUserName()))
            return "User Exists";
        else
            userRepository.save(user);
            return "User Created";
    }
    

    public boolean userExists(String username){
        if(userRepository.findById(username).isPresent())
            return true;
        else
            return  false;
    }
}
