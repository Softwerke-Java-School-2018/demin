package com.miros.view;

import com.miros.controller.UserActivityController;

import java.time.LocalDate;
import java.util.Scanner;

public class UserActivityView  {
    public void userActivityMenu() {
        System.out.println("Enter the section number:\n" +
                "1 - create a purchase entry\n" +
                "2 - delete a purchase entry\n");

        String command = readLine();
        switch (command) {
            case "1":
                createUserActivityView();
            case "2":
                deleteUserActivityView();
        }
    }

    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    void createUserActivityView(){
        System.out.println("Enter the Id of the user who makes the purchase");
        Integer userId = Integer.parseInt(readLine());

        System.out.println("Enter the Id of the item you want to purchase");
        Integer deviceId = Integer.parseInt(readLine());
        LocalDate localDate = LocalDate.now();

        new UserActivityController().create(userId, deviceId, localDate);
    }

    void deleteUserActivityView(){
        System.out.println("Enter purchase id");
        Integer uavId = Integer.parseInt(readLine());
        new UserActivityController().delete(uavId);
    }
}














