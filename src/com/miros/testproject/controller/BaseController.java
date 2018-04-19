package com.miros.testproject.controller;

import com.miros.testproject.Base;
import com.miros.testproject.view.MainView;
import java.time.format.DateTimeFormatter;

public abstract class BaseController extends Base {
    private MainView mainView = new MainView();
    protected static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void waitForEnter() {
        while(true) {
            utils.printLine("Press Enter to back in main menu");
            String str = utils.readLine();
            if("".equals(str)){
                mainView.baseMenu();
            }
            else {
                utils.printLine("It's wrong, try again");
            }
        }
    }
}





















