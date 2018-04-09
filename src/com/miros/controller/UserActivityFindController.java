package com.miros.controller;

import com.miros.Main;
import com.miros.data.entity.UserActivity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Контроллер для истории покупок
 */

public class UserActivityFindController extends BaseController {


    /**
     * Поиск по имени покупателя
     * @param userName
     */
    public void userNameFind(String userName){
        for (UserActivity userActivity : Main.userActivityList){
             if(userActivity.getUser().getName().equals(userName)){
                 System.out.println(userActivity);
             }
        }
        waitForEnter();
    }


    /**
     * Поиск по модели устройства
     * @param model
     */
    public void deviceModelFind(String model){
        for (UserActivity userActivity : Main.userActivityList){
            if(userActivity.getDevice().getModel().equals(model)){
                System.out.println(userActivity);
            }
        }
        waitForEnter();
    }

    /**
     * Поиск по ID чека(Истории покупок)
     * @param userActivityId
     */
    public void userActivityIdFind(Integer userActivityId){
        System.out.println(Main.userActivityList.get(userActivityId));
        waitForEnter();
    }

    /**
     * Поиск по дате
     * @param date
     */
    public void localDateFind(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        for (UserActivity userActivity : Main.userActivityList){
            if(userActivity.getLocalDate().equals(localDate)){
                System.out.println(userActivity);
            }
        }
        waitForEnter();
    }
}
