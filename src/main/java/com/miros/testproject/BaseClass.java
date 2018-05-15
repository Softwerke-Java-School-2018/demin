package com.miros.testproject;

import com.miros.testproject.util.Utils;

import java.time.LocalDate;

/**
 * All classes extends from this class
 */
public abstract class BaseClass {
    protected static final Utils utils = new Utils();
    protected static LocalDate localDate;
    protected void waitForEnter(){
        utils.waitForEnter();
    }
}

