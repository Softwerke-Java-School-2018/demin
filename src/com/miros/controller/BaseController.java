package com.miros.controller;

import com.miros.view.BaseView;
import java.util.Scanner;

public class BaseController {

    protected BaseView baseView = new BaseView();

    public BaseController() {
    }

    private String readLine(){
        System.out.println("Press Enter to back in main menu");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected void waitForEnter(){
        while (readLine().equals("")){
            baseView.baseMenu();
        }
    }

    protected void clearScr(){
    }

}





















