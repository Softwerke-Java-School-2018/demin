package com.miros.testproject.controller.activity;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.DAO.UserActivityDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.UserActivity;
import com.miros.testproject.service.UserActivityService;
import com.miros.testproject.service.UserService;

import javax.rmi.CORBA.Util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class UserActivityFindController extends BaseController {
    private static UserActivityFindController userActivityFindController = new UserActivityFindController();
    private static UserService userService = UserService.getInstance();
    private static UserActivityService userActivityService = UserActivityService.getInstance();

    public UserActivityFindController() {
    }
    public static UserActivityFindController getInstance() {
        return userActivityFindController;
    }
    /**
     * Name find
     * @param userName
     */
    public void userNameFind(String userName) {
        for (UserActivity userActivity : UserActivityDAO.getInstance()) {
            if (userActivity.getUser().getName().equals(userName)) {
                Utils.printLine(userActivity);
            }
        }
        waitForEnter();
    }
    /**
     * @param model
     */
    public void deviceModelFind(String model) {
        List<UserActivity> userActivityList = userActivityService.showAll()
                .map(UserActivity::getUserActivity)
                .collect(Collectors.toList());
        int count=0;
        for(UserActivity userActivity : userActivityList){
            for (Device device : userActivity.getDeviceList()){
                if(device.getModel().equalsIgnoreCase(model) && count==0)
                {
                    Utils.printLine(userActivity);
                    count++;
                }
            }
            count=0;
        }
        waitForEnter();
    }
    /**
     * @param userActivityId
     */
    public void userActivityIdFind(int userActivityId) {
        try {
            UserActivity userActivity;
            userActivity = userActivityService.find(userActivityId);
            Utils.printLine(userActivity);
            waitForEnter();
        } catch (IndexOutOfBoundsException e){
            Utils.printLine(e.getMessage());
            waitForEnter();
        }
    }
    /**
     * @param date
     */
    public void localDateFind(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        waitForEnter();
    }
}
