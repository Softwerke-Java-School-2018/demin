package com.miros.testproject.controller.activity;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.data.entity.UserActivity;
import com.miros.testproject.exception.RuntimeEx;
import com.miros.testproject.service.BaseClassService;
import com.miros.testproject.service.DeviceService;
import com.miros.testproject.service.UserActivityService;
import com.miros.testproject.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller for Create, Delete, Update UserActivity Entity
 */
public class UserActivityController extends BaseController {
    private UserService userService = BaseClassService.getInstance().getUserService();
    private DeviceService deviceService = BaseClassService.getInstance().getDeviceService();
    private UserActivityService userActivityService = BaseClassService.getInstance().getUserActivityService();
    private static final Logger log = LoggerFactory.getLogger(UserActivityController.class);
    private volatile UserActivity userActivity;

    //Stream?
    /*
       Map Device id, device count;
      */
    public Optional<UserActivity> create(int userId, Map<Integer, Integer> deviceMap, LocalDate localDate) {
        try {
            boolean userCheck = userService.exist(userId);
            List<Device> deviceList = new ArrayList();
            User user;
            if (userCheck) {
                user = userService.find(userId);
                for (Map.Entry<Integer, Integer> entry : deviceMap.entrySet()) {
                    int deviceId = entry.getKey();
                    if (!deviceService.exist(deviceId)) {
                        utils.printLine("Device with " + deviceId + " number doesn't exist");
                        throw new RuntimeEx("UserActivity create: Device doesnt exist id: " + deviceId);
                    } else {
                        Device device = deviceService.find(deviceId);
                        deviceList.add(device);
                        log.info("UserActivity create: Device added in UserActivity.deviceList, Device id: " + deviceId);
                    }
                }
                userActivity = UserActivity.builder()
                        .setUser(user)
                        .setDeviceList(deviceList)
                        .setDate(localDate)
                        .build();
                                userActivityService.save(userActivity);
                log.info("UserActivity create: UserActivity created id: " + userActivity.getId());
                utils.printLine("Purchase created");
                waitForEnter();
                return Optional.of(userActivity);
            }
            utils.printLine("User with id: " + userId + " doesn't exist");
            waitForEnter();
        } catch (RuntimeEx e) {
            log.info(e.getMessage(), e);
        }
        return empty;
    }

    public Optional<UserActivity> delete(Integer id) {
        try {
            userActivity = userActivityService.delete(id);
            utils.printLine("Purchase deleted");
            waitForEnter();
            return Optional.of(userActivity);
        } catch (RuntimeEx e) {
            utils.printLine("Purchase with id" + id + " doesn't exist");
            log.info("UserActivity create: Delete UserActivity Runtime problem, id: " + id, e);
            waitForEnter();
        }
        return empty;
    }
}
