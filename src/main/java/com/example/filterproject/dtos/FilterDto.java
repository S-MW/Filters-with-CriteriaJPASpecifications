package com.example.filterproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @RequiredArgsConstructor @Getter @Setter
public class FilterDto {
    private String name;
    private Integer age;
}
