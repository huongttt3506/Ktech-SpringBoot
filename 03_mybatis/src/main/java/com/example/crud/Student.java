package com.example.crud;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private String email;
}
