package com.example.model;

import lombok.*;

@Data
@NoArgsConstructor      // пустой конструктор
@AllArgsConstructor     // конструктор со всеми полями
public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;
}
