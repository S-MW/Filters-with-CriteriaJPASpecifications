package com.example.filterproject.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @Data @AllArgsConstructor @RequiredArgsConstructor
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    private Long id;

    private String name;

    private int age;
}
