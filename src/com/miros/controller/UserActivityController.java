package com.miros.controller;

import com.miros.Main;
import com.miros.data.DateBase;
import com.miros.data.entity.Device;
import com.miros.data.entity.User;
import com.miros.data.entity.UserActivity;

import java.time.LocalDate;

/**
 * Контроллер истории покупок
 */

public class UserActivityController extends BaseController {

    private static UserActivityController userActivityController = new UserActivityController();

    public  UserActivityController(){}

    public static UserActivityController getInstance(){
        return userActivityController;
    }

    public void create(Integer userId, Integer deviceId, LocalDate localDate){

        User user = DateBase.userList.get(userId);
        Device device = DateBase.deviceList.get(deviceId);

        DateBase.userActivityList.add(new UserActivity(user, device, localDate));
        System.out.println("Purchase created");
        waitForEnter();
    }
// Как правильно сделать наследование?

    public void delete(Integer id){
        DateBase.userActivityList.remove(id);
        System.out.println("Purchase deleted");
        waitForEnter();
    }

}
