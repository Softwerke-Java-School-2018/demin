package com.miros.testproject.controller.activity;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.sort.SortClass;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.UserActivity;
import com.miros.testproject.exception.RuntimeEx;
import com.miros.testproject.service.BaseClassService;
import com.miros.testproject.service.UserActivityService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.List;


/**
 * Controller for find UserActivity elements
 */
public class UserActivityFindController extends BaseController {
    private UserActivityService userActivityService = BaseClassService.getInstance().getUserActivityService();
    private SortClass sortClass = SortClass.getInstance();
    private List<UserActivity> userActivityList;

    public void findUser(String userName) {
        userActivityList = userActivityService
                .findAll()
                .filter(s -> s.getUser()
                        .getName()
                        .equalsIgnoreCase(userName))
                .collect(Collectors.toList());
        userActivityList
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserActivityFindController.class, userActivityList.stream());
    }

    /**
     * Find UserActivity by name from Device List contains in UserActivity
     *
     * @param model
     */
    public void findDevice(String model) {
        userActivityList = userActivityService
                .findAll()
                .collect(Collectors.toList());
        List<UserActivity> tempList = new ArrayList<>();
        AtomicInteger count = new AtomicInteger(0);
        for (UserActivity userActivity : userActivityList) {
            for (Device device : userActivity.getDeviceList()) {
                if (device.getModel().equalsIgnoreCase(model) && count.get() == 0) {
                    utils.printLine(userActivity);
                    tempList.add(userActivity);
                    count.incrementAndGet();
                }
            }
            count.set(0);
        }
        sortClass.sortFunc(UserActivityFindController.class, userActivityList.stream());
    }

    /**
     * @param userActivityId
     */
    public void findId(int userActivityId) {
        try {
            utils.printLine(userActivityService.find(userActivityId));
            waitForEnter();
        } catch (RuntimeEx e) {
            utils.printLine(e.getMessage());
        }
        sortClass.sortFunc(UserActivityFindController.class, userActivityList.stream());
    }

    /**
     * @param date
     */
    public void findDate(String date) {
        localDate = LocalDate.parse(date, formatter);
        userActivityList = userActivityService
                .findAll()
                .filter(s -> s.getLocalDate().equals(localDate))
                .collect(Collectors.toList());
        userActivityList
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserActivityFindController.class, userActivityList.stream());
    }
}
