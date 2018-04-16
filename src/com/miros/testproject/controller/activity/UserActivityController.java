package com.miros.testproject.controller.activity;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.DAO.UserActivityDAO;
import com.miros.testproject.data.DAO.UserDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.data.entity.UserActivity;

import java.time.LocalDate;

/**
 * Контроллер истории покупок
 */

public class UserActivityController extends BaseController {
    private static UserActivityController userActivityController = new UserActivityController();

    public UserActivityController() {
    }

    public static UserActivityController getInstance() {
        return userActivityController;
    }

    public void create(Integer userId, Integer deviceId, LocalDate localDate) {
        User user = UserDAO.userDAO.get(userId);
        Device device = DeviceDAO.deviceDAO.get(deviceId);

        UserActivityDAO.userActivityDAO.add(new UserActivity(user, device, localDate));
        Utils.printLine("Purchase created");
        waitForEnter();
    }

    // Как правильно сделать наследование?
    public void delete(Integer id) {
        UserActivityDAO.userActivityDAO.remove(id);
        Utils.printLine("Purchase deleted");
        waitForEnter();
    }
}
