package com.miros.data.entity;

import java.time.LocalDate;

public class User {
    private static long userId=0;
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDay;

    public User(String name, String surname, String patronymic, LocalDate birthDay){
        this.id = userId++;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
    }

    public User(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }


    public LocalDate getBirthDay() {
        return birthDay;
    }
}
