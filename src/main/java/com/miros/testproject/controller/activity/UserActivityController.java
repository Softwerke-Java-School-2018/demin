package com.miros.testproject.controller.activity;

import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.data.entity.UserActivity;
import com.miros.testproject.service.DeviceService;
import com.miros.testproject.service.UserActivityService;
import com.miros.testproject.service.UserService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class UserActivityController extends BaseClassController {
    private UserService userService = new UserService();
    private DeviceService deviceService = new DeviceService();
    private UserActivityService userActivityService = new UserActivityService();
    //Stream?
    /*
       Map Device id, device count;
      */
    public void create(int userId, Map<Integer,Integer> deviceMap, LocalDate localDate) {
        boolean userCheck = userService.exist(userId);
        List<Device> deviceList = new ArrayList();
        User user;
        if(userCheck){
            user = userService.find(userId);
            for (Map.Entry<Integer, Integer> entry : deviceMap.entrySet()){
                int deviceId = entry.getKey();
                int deviceCount = entry.getValue();
                if(!deviceService.exist(deviceId)){
                    utils.printLine("Device with "+deviceId+" number doesn't exist");
                    waitForEnter();
                }
                else {
                    Device device = deviceService.find(deviceId);
                    deviceList.add(device);
                }
            }
            UserActivity userActivity = new UserActivity(user, deviceList, localDate);
            userActivityService.save(userActivity);
            utils.printLine("Purchase created");
            waitForEnter();
        }
        utils.printLine("User with id: " + userId + " doesn't exist");
        waitForEnter();
    }

    public void delete(Integer id) {
        try {
            userActivityService.delete(id);
            utils.printLine("Purchase deleted");
            waitForEnter();
        } catch (IndexOutOfBoundsException e) {
            utils.printLine("Purchase with id" + id + " doesn't exist");
            waitForEnter();
        }
    }
}
