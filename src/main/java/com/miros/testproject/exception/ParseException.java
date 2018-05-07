package com.miros.testproject.exception;

import java.time.DateTimeException;

public class ParseException extends DateTimeException {
    public ParseException(String message) {
        super(message);
    }
}
