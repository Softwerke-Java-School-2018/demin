package com.miros.testproject.data.entity;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDay;

    public User(String name, String surname, String patronymic, LocalDate birthDay) {
        this.id = atomicInteger.incrementAndGet();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
    }

    public synchronized User getUser() {
        return this;
    }

    public int getId() {
        return id;
    }
}
