package com.miros.testproject.view;

import com.miros.testproject.view.activity.UserActivityFindView;
import com.miros.testproject.view.device.DeviceFindView;
import com.miros.testproject.view.user.UserFindView;
import lombok.Data;

@Data
public class FindView extends BaseClassView {
    private UserFindView userFindView;
    private DeviceFindView deviceFindView;
    private UserActivityFindView userActivityFindView;
    private final String FIND_VIEW = "Enter the section number:\n" +
            "1 - users search\n" +
            "2 - devices search\n" +
            "3 - purchase history search\n";

    public FindView() {
        this.userFindView = new UserFindView();
        this.deviceFindView = new DeviceFindView();
        this.userActivityFindView = new UserActivityFindView();
    }

    public void findMenu() {
        utils.printLine(FIND_VIEW);
        String num = utils.readLine();
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
