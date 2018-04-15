package com.miros.view;

import com.miros.Utils;
import com.miros.view.activity.UserActivityView;
import com.miros.view.device.DeviceView;
import com.miros.view.user.UserView;

/**
 * Главный раздел модуля View
 */
public class BaseView {

    private UserView userView;
    private DeviceView deviceView;
    private UserActivityView userActivityView;
    private FindView findView;

    private final String BASE_VIEW = "Enter the section number: \n" +
            "1 - user management \n" +
            "2 - device management \n" +
            "3 - managing the history of purchases \n" +
            "4 - search \n";


    public BaseView() {
        this.userView = new UserView();
        this.deviceView = new DeviceView();
        this.userActivityView = new UserActivityView();
        this.findView = new FindView();
    }

    public void baseMenu() {
        Utils.printLine(BASE_VIEW);
            String command = Utils.readLine();
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
}
