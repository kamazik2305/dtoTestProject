package com.example.dtoTestProject.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String surname;
    private String name;
    private int age;
}
