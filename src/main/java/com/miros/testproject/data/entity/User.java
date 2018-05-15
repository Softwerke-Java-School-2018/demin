package com.miros.testproject.data.entity;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.miros.testproject.exception.ParseException;
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

    public User(Builder userBuilder) {
        this.id = atomicInteger.incrementAndGet();
        this.name = userBuilder.name;
        this.surname = userBuilder.surname;
        this.patronymic = userBuilder.patronymic;
        this.birthDay = userBuilder.birthDay;
    }

    public static void refreshAtomicInteger(){
        atomicInteger.set(0);
    }

    public synchronized User getUser() {
        return this;
    }

    public int getId() {
        return this.id;
    }

    public static Builder builder() {
        return new User.Builder();
    }

    public static class Builder {
        private String name;
        private String surname;
        private String patronymic;
        private LocalDate birthDay;

        public Builder setName(String name) {
            Optional<String> optName = Optional.of(name);
            if (optName.isPresent()) {
                this.name = optName.get();
                return this;
            }
            this.name = "";
            return this;
        }

        public Builder setSurname(String surname) {
            Optional<String> optSurname = Optional.of(surname);
            if (optSurname.isPresent()) {
                this.surname = optSurname.get();
                return this;
            }
            this.surname = "";
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            Optional<String> optModel = Optional.of(patronymic);
            if (optModel.isPresent()) {
                this.patronymic = optModel.get();
                return this;
            }
            this.patronymic = "";
            return this;
        }

        public Builder setBirthDay(LocalDate localDate) {
            Optional<LocalDate> optDate = Optional.of(localDate);
            if (!optDate.isPresent()) {
                throw new DateTimeException("Birthday is null");
            }
            this.birthDay = LocalDate.now();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
