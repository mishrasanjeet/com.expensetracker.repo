package com.home.assignment.com.expense.tracker.Service;

import com.home.assignment.com.expense.tracker.Repository.UserRepository;
import com.home.assignment.com.expense.tracker.UserEntiry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user){
        userRepository.save(user);
    }



}
