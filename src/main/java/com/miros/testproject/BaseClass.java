package com.miros.testproject;

import com.miros.testproject.util.Utils;

import java.time.LocalDate;

public abstract class BaseClass {
    protected final Utils utils = new Utils();
    protected LocalDate localDate;
    protected void waitForEnter(){
        utils.waitForEnter();
    }
}

