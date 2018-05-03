package com.miros.testproject.view;


import com.miros.testproject.view.activity.UserActivityView;
import com.miros.testproject.view.device.DeviceView;
import com.miros.testproject.view.user.UserView;
import lombok.Data;


@Data
public class MainMenuView extends BaseClassView {
    private UserView userView;
    private DeviceView deviceView;
    private UserActivityView userActivityView;
    private FindView findView;
    private BaseSort baseSort;
    private final String BASE_VIEW = "Enter the section number: \n" +
            "1 - user management \n" +
            "2 - device management \n" +
            "3 - managing the history of purchases \n" +
            "4 - search \n";

    public MainMenuView() {
        this.userView = new UserView();
        this.deviceView = new DeviceView();
        this.userActivityView = new UserActivityView();
        this.findView = new FindView();
        this.baseSort = new BaseSort();
    }
    public void baseMenu() {
        utils.printLine(BASE_VIEW);
            String command = utils.readLine();
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
