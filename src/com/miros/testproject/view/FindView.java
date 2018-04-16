package com.miros.testproject.view;

import com.miros.testproject.Utils;
import com.miros.testproject.view.activity.UserActivityFindView;
import com.miros.testproject.view.device.DeviceFindView;
import com.miros.testproject.view.user.UserFindView;


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
                    deviceFindView.deviceFinder();
                case "2":
                    userFindView.userFinder();
                case "3":
                    userActivityFindView.userActivityFinder();
            }
    }
}