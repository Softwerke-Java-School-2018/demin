package com.miros.testproject.view.activity;

import com.miros.testproject.controller.activity.UserActivityController;
import com.miros.testproject.view.BaseView;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class UserActivityView extends BaseView {
    private UserActivityController userActivityController = new UserActivityController();
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
        }
    }
    /*
    Доработать метод с несколькими покупками где можно выбрать count купленных устройств
    изменить контроллер для передачи коллекции с дейвайсами и кол-вом
     */
    void createUserActivityView() {
        boolean flug = true;
        int userId=0;
        int deviceId=0;
        /*
        Device id, device count;
         */
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














