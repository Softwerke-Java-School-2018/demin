package com.miros.testproject;

import com.miros.testproject.view.MainView;

import java.time.LocalDate;

public abstract class Base {
    protected final Utils utils = new Utils();
    protected LocalDate localDate;
    protected void waitForEnter(){
        utils.waitForEnter();
    }
}

