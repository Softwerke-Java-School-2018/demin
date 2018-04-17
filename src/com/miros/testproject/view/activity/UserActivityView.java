package com.miros.testproject.view.activity;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.activity.UserActivityController;
import com.miros.testproject.controller.device.DeviceController;
import com.miros.testproject.controller.device.DeviceFindController;
import com.miros.testproject.controller.user.UserController;
import com.miros.testproject.controller.user.UserFindController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.view.BaseView;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserActivityView extends BaseView {
    private UserActivityController userActivityController = UserActivityController.getInstance();
    private UserController userController = UserController.getInstance();
    private UserFindController userFindController = UserFindController.getInstance();
    private DeviceController deviceController = DeviceController.getInstance();
    private DeviceFindController deviceFindController = DeviceFindController.getInstance();



    private final String USER_ACTIVITY_VIEW = "Enter the section number:\n" +
            "1 - create a purchase entry\n" +
            "2 - delete a purchase entry\n";

    public void userActivityMenu() {
        Utils.printLine(USER_ACTIVITY_VIEW);
        String command = Utils.readLine();
        switch (command) {
            case "1":
                createUserActivityView();
            case "2":
                deleteUserActivityView();
        }
    }

    //

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
        Utils.printLine("Enter the Id of the user who makes the purchase");
        userId = Integer.parseInt(Utils.readLine());
        while (flug) {
            Utils.printLine("Enter the Id of the item you want to purchase");
            deviceId = Integer.parseInt(Utils.readLine());

            Utils.printLine("Enter count of device you want to purchase");
            int deviceCount = Integer.parseInt(Utils.readLine());

            deviceMap.put(deviceId, deviceCount);
            flug = Utils.answer();
        }
        LocalDate localDate = LocalDate.now();
        userActivityController.create(userId, deviceMap, localDate);
    }
    void deleteUserActivityView() {
        Utils.printLine("Enter purchase id");
        int userId = Integer.parseInt(Utils.readLine());
        userActivityController.delete(userId);
    }
}














