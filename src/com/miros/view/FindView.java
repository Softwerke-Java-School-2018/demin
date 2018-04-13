package com.miros.view;

import com.miros.controller.DeviceFindController;
import com.miros.controller.UserActivityController;
import com.miros.controller.UserActivityFindController;
import com.miros.controller.UserFindController;

import java.util.Scanner;
/**
 * Модуль View поиска по каталогу
 */
public class FindView {
    public void findMenu() {
            System.out.println("Enter the section number:\n" +
            "1 - devices search\n" +
            "2 - users search\n" +
            "3 - purchase history search\n");

            String num = readLine();
            switch (num) {
                case "1":
                    deviceFinder();
                case "2":
                    userFinder();
                case "3":
                    userActivityFinder();
            }
    }

    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    /**
     * Модуль поиска устройств
     */
    private void deviceFinder(){
        System.out.println("Choose which parameter will be searched\n" +
                "1 - id\n" +
                "2 - Type\n" +
                "3 - Color\n" +
                "4 - Show all devices");
        String num = readLine();
        switch (num) {
            case "1":
                System.out.println("Enter id");
                Integer id = Integer.parseInt(readLine());
                DeviceFindController.getInstance().deviceIdFind(id);
            case "2":
                System.out.println("Enter type");
                String type = readLine();
                DeviceFindController.getInstance().deviceTypeFind(type);
            case "3":
                System.out.println("Enter color");
                String color = readLine();
                DeviceFindController.getInstance().deviceColorFind(color);
            case "4":
                DeviceFindController.getInstance().showAllDevices();
        }
    }

    /**
     * Модуль поиска пользователей
     */

    private void userFinder(){
        System.out.println("Choose which parameter will be searched\n" +
                "1 - id\n" +
                "2 - Name\n" +
                "3 - Birthday\n" +
                "4 - Show all users");
        String num = readLine();
        switch (num) {
            case "1":
                System.out.println("Enter id");
                Integer id = Integer.parseInt(readLine());
                UserFindController.getInstance().userIdFind(id);
            case "2":
                System.out.println("Enter Name");
                String name = readLine();
                UserFindController.getInstance().userNameFind(name);
            case "3":
                System.out.println("Enter BirthDay like 12/06/1994");
                String birthDay = readLine();
                UserFindController.getInstance().localDateFind(birthDay);
            case "4":
                UserFindController.getInstance().showAllUsers();
        }
    }

    /**
     * Модуль поиска истории покупок
     */

    private void userActivityFinder(){
        System.out.println("Choose which parameter will be searched\n" +
                "1 - id\n" +
                "2 - userName\n" +
                "3 - DeviceId\n" +
                "4 - Date");
        String num = readLine();
        switch (num) {
            case "1":
                System.out.println("Enter userActivity id");
                Integer id = Integer.parseInt(readLine());
                UserActivityFindController.getInstance().userActivityIdFind(id);
            case "2":
                System.out.println("Enter UserName");
                String userName = readLine();
                UserActivityFindController.getInstance().userNameFind(userName);
            case "3":
                System.out.println("Enter DeviceId");
                String deviceName = readLine();
                UserActivityFindController.getInstance().deviceModelFind(deviceName);
            case "4":
                System.out.println("Enter date like 12/06/1994");
                String date = readLine();
                UserActivityFindController.getInstance().localDateFind(date);
        }
    }
}
