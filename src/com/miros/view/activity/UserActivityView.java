package com.miros.view.activity;

import com.miros.Utils;
import com.miros.controller.activity.UserActivityController;

import java.time.LocalDate;
import java.util.Scanner;

public class UserActivityView  {

    private final String USER_ACTIVITY_VIEW="Enter the section number:\n" +
            "1 - create a purchase entry\n" +
            "2 - delete a purchase entry\n";

    public void userActivityMenu() {
        Utils.printLine(USER_ACTIVITY_VIEW);
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
        Utils.printLine("Enter the Id of the user who makes the purchase");
        Integer userId = Integer.parseInt(readLine());

        Utils.printLine("Enter the Id of the item you want to purchase");
        Integer deviceId = Integer.parseInt(readLine());
        LocalDate localDate = LocalDate.now();

        UserActivityController.getInstance().create(userId, deviceId, localDate);
    }

    void deleteUserActivityView(){
        Utils.printLine("Enter purchase id");
        Integer uavId = Integer.parseInt(readLine());
        UserActivityController.getInstance().delete(uavId);
    }
}














