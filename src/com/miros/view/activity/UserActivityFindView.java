package com.miros.view.activity;

import com.miros.Utils;
import com.miros.controller.activity.UserActivityFindController;

public class UserActivityFindView {

    private final String USER_ACTIVITY_FIND_VIEW="Choose which parameter will be searched\n" +
            "1 - id\n" +
            "2 - userName\n" +
            "3 - DeviceId\n" +
            "4 - Date";

    /**
     * Модуль поиска истории покупок
     */
    public void userActivityFinder(){
        Utils.printLine(USER_ACTIVITY_FIND_VIEW);
        String num = Utils.readLine();
        switch (num) {
            case "1":
                Utils.printLine("Enter userActivity id");
                Integer id = Integer.parseInt(Utils.readLine());
                UserActivityFindController.getInstance().userActivityIdFind(id);
            case "2":
                Utils.printLine("Enter UserName");
                String userName = Utils.readLine();
                UserActivityFindController.getInstance().userNameFind(userName);
            case "3":
                Utils.printLine("Enter DeviceId");
                String deviceName = Utils.readLine();
                UserActivityFindController.getInstance().deviceModelFind(deviceName);
            case "4":
                Utils.printLine("Enter date like dd/MM/yyyy");
                String date = Utils.readLine();
                UserActivityFindController.getInstance().localDateFind(date);
        }
    }
}
