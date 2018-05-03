package com.miros.testproject.controller.activity;

import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.UserActivity;
import com.miros.testproject.service.UserActivityService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class UserActivityFindController extends BaseClassController {
    private UserActivityService userActivityService = new UserActivityService();
    private List<UserActivity> tempUserActivityDAO = tempDataService.getTempDAOUserActivityList();
    private List<UserActivity> userActivityList;

    public void findByUser(String userName) {
        userActivityList = userActivityService
                .findAll()
                .filter(s -> s.getUser()
                        .getName()
                        .equalsIgnoreCase(userName))
                .collect(Collectors.toList());
        userActivityList
                .forEach(s -> utils.printLine(s));
        tempUserActivityDAO.clear();
        tempUserActivityDAO.addAll(userActivityList);
        utils.sortFunc(userActivityFindController);
    }

    /**
     * @param model
     */
    public void find_By_Device_Model(String model) {
        userActivityList = userActivityService
                .findAll()
                .collect(Collectors.toList());
        List<UserActivity> tempList = new ArrayList<>();
        int count = 0;
        for (UserActivity userActivity : userActivityList) {
            for (Device device : userActivity.getDeviceList()) {
                if (device.getModel().equalsIgnoreCase(model) && count == 0) {
                    utils.printLine(userActivity);
                    tempList.add(userActivity);
                    count++;
                }
            }
            count = 0;
        }
        tempUserActivityDAO.clear();
        tempUserActivityDAO.addAll(userActivityList);
        utils.sortFunc(userActivityFindController);
    }

    /**
     * @param userActivityId
     */
    public void findId(int userActivityId) {
        try {
            utils.printLine(userActivityService.find(userActivityId));
            waitForEnter();
        } catch (IndexOutOfBoundsException e) {
            utils.printLine(e.getMessage());
        }
        tempUserActivityDAO.clear();
        tempUserActivityDAO.addAll(userActivityList);
        utils.sortFunc(userActivityFindController);
    }

    /**
     * @param date
     */
    public void localDateFind(String date) {
        localDate = LocalDate.parse(date, formatter);
        userActivityList = userActivityService
                .findAll()
                .filter(s -> s.getLocalDate().equals(localDate))
                .collect(Collectors.toList());
        userActivityList
                .forEach(s -> utils.printLine(s));
        tempUserActivityDAO.clear();
        tempUserActivityDAO.addAll(userActivityList);
        utils.sortFunc(userActivityFindController);
    }
}
