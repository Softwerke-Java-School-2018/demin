package com.miros.testproject.view.activity;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.activity.UserActivityFindController;

public class UserActivityFindView {

    private UserActivityFindController userActivityFindController = UserActivityFindController.getInstance();
    private final String USER_ACTIVITY_FIND_VIEW = "Choose which parameter will be searched\n" +
            "1 - User_Activity_id\n" +
            "2 - userName\n" +
            "3 - Device_Model\n" +
            "4 - Date";


    public void userActivityFinder() {
        Utils.printLine(USER_ACTIVITY_FIND_VIEW);
        String num = Utils.readLine();
        switch (num) {
            case "1":
                Utils.printLine("Enter userActivity id");
                Integer id = Integer.parseInt(Utils.readLine());
                userActivityFindController.userActivityIdFind(id);
            case "2":
                Utils.printLine("Enter UserName");
                String userName = Utils.readLine();
                userActivityFindController.userNameFind(userName);
            case "3":
                Utils.printLine("Enter DeviceModel");
                String deviceName = Utils.readLine();
                userActivityFindController.deviceModelFind(deviceName);
            case "4":
                Utils.printLine("Enter date like dd/MM/yyyy");
                String date = Utils.readLine();
                userActivityFindController.localDateFind(date);
        }
    }
}
