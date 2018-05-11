package com.miros.testproject.controller;

import com.miros.testproject.BaseClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Optional;


import com.miros.testproject.exception.RuntimeEx;

import lombok.Data;

/**
 * All controllers extends from this class,
 * this class Init all controllers for app
 */

@Data
public class BaseController extends BaseClass {
    protected final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //Application use this
    protected Optional empty = Optional.empty();

    protected LocalDate dateParser(String date) throws RuntimeEx {
        localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
}





















