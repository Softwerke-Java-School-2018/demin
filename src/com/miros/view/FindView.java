package com.miros.view;

import com.miros.Utils;
import com.miros.view.activity.UserActivityFindView;
import com.miros.view.device.DeviceFindView;
import com.miros.view.user.UserFindView;

/**
 * Модуль View поиска по каталогу
 */
public class FindView {
    private UserFindView userFindView;
    private DeviceFindView deviceFindView;
    private UserActivityFindView userActivityFindView;

    private final String FIND_VIEW="Enter the section number:\n" +
            "1 - devices search\n" +
            "2 - users search\n" +
            "3 - purchase history search\n";

    public FindView(){
        this.userFindView = new UserFindView();
        this.deviceFindView = new DeviceFindView();
        this.userActivityFindView = new UserActivityFindView();
    }

    public void findMenu() {
        Utils.printLine(FIND_VIEW);
            String num = Utils.readLine();
            switch (num) {
                case "1":
                    userFindView.userFinder();
                case "2":
                    deviceFindView.deviceFinder();
                case "3":
                    userActivityFindView.userActivityFinder();
            }
    }
}
