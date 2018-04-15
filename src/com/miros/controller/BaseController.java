package com.miros.controller;

import com.miros.Utils;
import com.miros.view.BaseView;

public class BaseController {

    private static BaseView baseView = new BaseView();
    private final Utils utils = new Utils();

    public BaseController() {
    }

    protected BaseView getBaseView() {
        return baseView;
    }

    public void waitForEnter() {
        while(true) {
            Utils.printLine("Pres Enter to back in main menu");
            String str = utils.scanner().nextLine();
            if(str.equals("")){
                baseView.baseMenu();
            }
            else {
                Utils.printLine("It's wrong, try again");
            }
        }
    }
}





















