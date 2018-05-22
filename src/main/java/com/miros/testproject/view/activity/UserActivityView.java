package com.miros.testproject.view.activity;

import com.miros.testproject.controller.ControllersFabric;
import com.miros.testproject.controller.activity.UserActivityController;
import com.miros.testproject.view.BaseView;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * This class creates a menu for Create, Delete, Update
 *  some UserActivities and redirect on UserActivity Controller
 */
public class UserActivityView extends BaseView {
    private UserActivityController userActivityController = (UserActivityController) ControllersFabric.getController(UserActivityController.class).get();
    private final String USER_ACTIVITY_VIEW = "Enter the section number:\n" +
            "1 - create a purchase entry\n" +
            "2 - delete a purchase entry\n";
    public void userActivityMenu() {
        utils.printLine(USER_ACTIVITY_VIEW);
        String command = utils.readLine();
        switch (command) {
            case "1":
                createUserActivityView();
            case "2":
                deleteUserActivityView();
            default:
               return;
        }
    }

    void createUserActivityView() {
        boolean flug = true;
        int userId;
        int deviceId;
        Map<Integer, Integer> deviceMap = new HashMap();
        utils.printLine("Enter the Id of the user who makes the purchase");
        userId = Integer.parseInt(utils.readLine());
        while (flug) {
            utils.printLine("Enter the Id of the item you want to purchase");
            deviceId = Integer.parseInt(utils.readLine());
            utils.printLine("Enter count of device you want to purchase");
            int deviceCount = Integer.parseInt(utils.readLine());
            deviceMap.put(deviceId, deviceCount);
            flug = utils.answer();
        }
        localDate = LocalDate.now();
        userActivityController.create(userId, deviceMap, localDate);
    }
    void deleteUserActivityView() {
        utils.printLine("Enter purchase id");
        int userId = Integer.parseInt(utils.readLine());
        userActivityController.delete(userId);
    }
}














