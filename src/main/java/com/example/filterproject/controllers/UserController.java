package com.example.filterproject.controllers;

import com.example.filterproject.entities.User;
import com.example.filterproject.services.UserService;
import com.example.filterproject.dtos.FilterDto;
import jakarta.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("v1")
    public ResponseEntity<List<User>> getUsersWithFilter(@RequestBody(required = false) FilterDto filterDto) {

        Specification<User> userSpecification = getSpecification(filterDto);
        List<User> users = userService.getUsersWithFilter(userSpecification);
        return ResponseEntity.ok().body(users);
    }

    private Specification<User> getSpecification(FilterDto filterDto) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filterDto.getName() != null && !filterDto.getName().isEmpty()) {
                System.out.println("getName");
                predicates.add(criteriaBuilder.equal(root.get("name"), filterDto.getName()));
            }
            if (filterDto.getAge() != null) {
                System.out.println("getAge");
                predicates.add(criteriaBuilder.equal(root.get("age"), filterDto.getAge()));
            }

//            query.orderBy(criteriaBuilder.desc(root.get("id")));

            if (predicates.isEmpty()) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };

    }
}
