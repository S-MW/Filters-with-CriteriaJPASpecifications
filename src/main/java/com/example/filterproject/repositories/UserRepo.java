package com.example.filterproject.repositories;

import com.example.filterproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepo extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
}
