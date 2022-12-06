package com.example.filterproject.services;

import com.example.filterproject.entities.User;
import com.example.filterproject.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public List<User> getUsersWithFilter(Specification<User> userSpecification) {
        return userRepo.findAll(userSpecification);
    }
}
