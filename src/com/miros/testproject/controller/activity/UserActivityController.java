package com.miros.testproject.controller.activity;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.DAO.*;
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

public class UserActivityController extends BaseController {

    private static UserActivityController userActivityController = new UserActivityController();
    private static UserService userService = UserService.getInstance();
    private static DeviceService deviceService = DeviceService.getInstance();
    private static UserActivityService userActivityService = UserActivityService.getInstance();

    public UserActivityController() {
    }

    public static UserActivityController getInstance() {
        return userActivityController;
    }

    //Stream?
    /*
       Map Device id, device count;
      */
    public void create(int userId, Map<Integer,Integer> deviceMap, LocalDate localDate) {
        boolean userCheck = userService.exist(userId);
        List<Device> deviceList = new ArrayList();
        User user;
        if(userCheck){
            user = userService.idFind(userId);
            for (Map.Entry<Integer, Integer> entry : deviceMap.entrySet()){
                int deviceId = entry.getKey();
                int deviceCount = entry.getValue();
                if(!deviceService.exist(deviceId)){
                    Utils.printLine("Device with "+deviceId+" number doesn't exist");
                    waitForEnter();
                }
                else {
                    Device device = deviceService.idFind(deviceId);
                    deviceList.add(device);
                }
            }
            UserActivity userActivity = new UserActivity(user, deviceList, localDate);
            userActivityService.save(userActivity);
            Utils.printLine("Purchase created");
            waitForEnter();
        }
        Utils.printLine("User with id:" + userId + " doesn't exist");
    }

    public void delete(Integer id) {
        try {
            UserActivityDAO.getInstance().remove(id);
            Utils.printLine("Purchase deleted");
            waitForEnter();
        } catch (IndexOutOfBoundsException e) {
            Utils.printLine("Purchase with " + id + " id number, doesn't exist");
            waitForEnter();
        }
    }
}
