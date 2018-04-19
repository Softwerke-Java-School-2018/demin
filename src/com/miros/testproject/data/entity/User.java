package com.miros.testproject.data.entity;

import java.time.LocalDate;

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
    public int getId() {
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
    public User getUser() {
        return this;
    }
    public LocalDate getBirthDay() {
        return birthDay;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + patronymic + " " + birthDay.toString();
    }
}
