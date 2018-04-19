package com.miros.testproject.view.activity;

import com.miros.testproject.controller.activity.UserActivityFindController;
import com.miros.testproject.view.BaseView;

public class UserActivityFindView extends BaseView {
    private UserActivityFindController userActivityFindController = new UserActivityFindController();
    private final String USER_ACTIVITY_FIND_VIEW = "Choose which parameter will be searched\n" +
            "1 - User_Activity_id\n" +
            "2 - userName\n" +
            "3 - Device_Model\n" +
            "4 - Date";

    public void userActivityFinder() {
        utils.printLine(USER_ACTIVITY_FIND_VIEW);
        String num = utils.readLine();
        switch (num) {
            case "1":
                utils.printLine("Enter userActivity id");
                Integer id = Integer.parseInt(utils.readLine());
                userActivityFindController.userActivityIdFind(id);
            case "2":
                utils.printLine("Enter UserName");
                String userName = utils.readLine();
                userActivityFindController.findUserName(userName);
            case "3":
                utils.printLine("Enter DeviceModel");
                String deviceName = utils.readLine();
                userActivityFindController.find_UserActivity_By_DeviceModel(deviceName);
            case "4":
                utils.printLine("Enter date like dd/MM/yyyy");
                String date = utils.readLine();
                userActivityFindController.localDateFind(date);
        }
    }
}
