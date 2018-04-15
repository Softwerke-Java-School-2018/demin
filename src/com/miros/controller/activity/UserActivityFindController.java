package com.miros.controller.activity;

import com.miros.Utils;
import com.miros.controller.BaseController;
import com.miros.data.DAO.UserActivityDAO;
import com.miros.data.entity.UserActivity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Контроллер для истории покупок
 */

public class UserActivityFindController extends BaseController {
    private static UserActivityFindController userActivityFindController = new UserActivityFindController();

    public  UserActivityFindController(){}

    public static UserActivityFindController getInstance(){
        return userActivityFindController;
    }
    /**
     * Поиск по имени покупателя
     * @param userName
     */
    public void userNameFind(String userName){
        for (UserActivity userActivity : UserActivityDAO.userActivityDAO){
             if(userActivity.getUser().getName().equals(userName)){
                 Utils.printLine(userActivity);
             }
        }
        waitForEnter();
    }


    /**
     * Поиск по модели устройства
     * @param model
     */
    public void deviceModelFind(String model){
        for (UserActivity userActivity : UserActivityDAO.userActivityDAO){
            if(userActivity.getDevice().getModel().equals(model)){
                Utils.printLine(userActivity);
            }
        }
        waitForEnter();
    }
    /**
     * Поиск по ID чека(Истории покупок)
     * @param userActivityId
     */
    public void userActivityIdFind(Integer userActivityId){
        Utils.printLine(UserActivityDAO.userActivityDAO.get(userActivityId));
        waitForEnter();
    }
    /**
     * Поиск по дате
     * @param date
     */
    public void localDateFind(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        for (UserActivity userActivity : UserActivityDAO.userActivityDAO){
            if(userActivity.getLocalDate().equals(localDate)){
                Utils.printLine(userActivity);
            }
        }
        waitForEnter();
    }
}
