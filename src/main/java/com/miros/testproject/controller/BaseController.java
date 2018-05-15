package com.miros.testproject.controller;

import com.miros.testproject.BaseClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Optional;


import com.miros.testproject.exception.RuntimeEx;

import lombok.Data;

/**
 * All controllers extends from this class
 *
 */

@Data
public class BaseController extends BaseClass {
    protected static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //Application use this
    protected Optional empty = Optional.empty();

    public static LocalDate dateParser(String date) throws RuntimeEx {
        localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
}





















