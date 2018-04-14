package com.miros.controller;

import com.miros.view.BaseView;
import java.util.Scanner;

public class BaseController {

    private static BaseView baseView = new BaseView();

    public BaseController() {
    }

    protected BaseView getBaseView() {
        return baseView;
    }

    public static void waitForEnter() {
        while (Utils.readLine().equals("")) {
            baseView.baseMenu();
        }
    }
}





















