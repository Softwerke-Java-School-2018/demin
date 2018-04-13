package com.miros.view;

import com.miros.controller.BaseController;

import java.util.Scanner;


/**
 * Главный раздел модуля View
 */
public class BaseView {

    private UserView userView;
    private DeviceView deviceView;
    private UserActivityView userActivityView;
    private FindView findView;


    public BaseView() {
        this.userView = new UserView();
        this.deviceView = new DeviceView();
        this.userActivityView = new UserActivityView();
        this.findView = new FindView();
    }

    public void baseMenu() {
            System.out.println("Enter the section number: \n" +
                    "1 - user management \n" +
                    "2 - device management \n" +
                    "3 - managing the history of purchases \n" +
                    "4 - search \n");

            String command = readLine();
            switch (command) {
                case "1":
                    userView.userMenu();
                case "2":
                    deviceView.deviceMenu();
                case "3":
                    userActivityView.userActivityMenu();
                case "4":
                    findView.findMenu();
            }
        }

    public String readLine(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

}
