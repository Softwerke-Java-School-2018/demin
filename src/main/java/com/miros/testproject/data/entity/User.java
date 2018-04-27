package com.miros.testproject.data.entity;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private static int userId = 0;
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDay;

    public User(String name, String surname, String patronymic, LocalDate birthDay) {
        this.id = userId++;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
    }
}
