package com.miros.controller;

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
        if (utils.mainMenu().nextLine().equals("")) {
            baseView.baseMenu();
        }
    }
}





















