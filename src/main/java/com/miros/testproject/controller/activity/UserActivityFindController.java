package com.miros.testproject.controller.activity;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.UserActivity;
import com.miros.testproject.service.UserActivityService;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.List;

public class UserActivityFindController extends BaseController {
    private UserActivityService userActivityService = new UserActivityService();
    /**
     * Name find
     *
     * @param userName
     */
    public void findUserName(String userName) {
        userActivityService
                .findAll()
                .filter(s -> s.getUser()
                        .getName()
                        .equalsIgnoreCase(userName))
                .forEach(e -> utils.printLine(e));
        waitForEnter();
    }
    /**
     * @param model
     */
    public void find_UserActivity_By_DeviceModel(String model) {
        List<UserActivity> userActivityList = userActivityService
                .findAll()
                .map(UserActivity::getUserActivity)
                .collect(Collectors.toList());
        int count = 0;
        for (UserActivity userActivity : userActivityList) {
            for (Device device : userActivity.getDeviceList()) {
                if (device.getModel().equalsIgnoreCase(model) && count == 0) {
                    utils.printLine(userActivity);
                    count++;
                }
            }
            count = 0;
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
            utils.printLine(userActivity);
            waitForEnter();
        } catch (IndexOutOfBoundsException e) {
            utils.printLine(e.getMessage());
            waitForEnter();
        }
    }
    /**
     * @param date
     */
    public void localDateFind(String date) {
        localDate = LocalDate.parse(date, formatter);
        waitForEnter();
    }
}
