package com.miros.view;

import com.miros.controller.BaseController;

import java.util.Scanner;

public class BaseView {


    private UserView userView = new UserView();
    private DeviceView deviceView = new DeviceView();
    private UserActivityView userActivityView = new UserActivityView();
    private FindView findView = new FindView();
   // private BaseController baseController = new BaseController();

    public BaseView() {
        //this.userView = new UserView();
        //this.deviceView = new DeviceView();
        // this.userActivityView = new UserActivityView();
        // this.baseController = new BaseController();
        // this.findView = new FindView();
    }

    public void baseMenu() {
            System.out.println("Введите номер раздела: \n" +
                    "1 - управление пользователями \n" +
                    "2 - управление устройствами \n" +
                    "3 - управление историей покупок \n" +
                    "4 - поиск \n");

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
//Нужны ли Геты?
    public String readLine(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    public UserView getUserView() {
        return userView;
    }

    public DeviceView getDeviceView() {
        return deviceView;
    }

    public UserActivityView getUserActivityView() {
        return userActivityView;
    }

    public FindView getFindView() {
        return findView;
    }
}
