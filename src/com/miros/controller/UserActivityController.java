package com.miros.controller;

import com.miros.Main;
import com.miros.data.entity.Device;
import com.miros.data.entity.User;
import com.miros.data.entity.UserActivity;

import java.time.LocalDate;

/**
 * Контроллер истории покупок
 */

public class UserActivityController extends BaseController {


    public void create(Integer userId, Integer deviceId, LocalDate localDate){

        User user = Main.userList.get(userId);
        Device device = Main.deviceList.get(deviceId);

        Main.userActivityList.add(new UserActivity(user, device, localDate));
        System.out.println("Purchase created");
        waitForEnter();
    }


    public void delete(Integer id){
        Main.userActivityList.remove(id);
        System.out.println("Purchase deleted");
        waitForEnter();
    }

}
