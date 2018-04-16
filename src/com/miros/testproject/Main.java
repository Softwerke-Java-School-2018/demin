package com.miros.testproject;

import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.DAO.UserActivityDAO;
import com.miros.testproject.data.DAO.UserDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.data.entity.UserActivity;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.view.BaseView;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    /**
     * Каталоги Пользователей, Устройств и Истории покупок
     */


    public static void main(String[] args) {
        DeviceType deviceType = DeviceType.LAPTOP;
        DeviceColor deviceColor = DeviceColor.BLACK;

        DeviceType deviceType1 = DeviceType.PHONE;
        DeviceColor deviceColor1 = DeviceColor.WHITE;

        DeviceType deviceType2 = DeviceType.TABLET;
        DeviceColor deviceColor2 = DeviceColor.BLACK;



        DeviceDAO.deviceDAO.add(new Device(deviceType, deviceColor,"asus7735"));
        DeviceDAO.deviceDAO.add(new Device(deviceType1, deviceColor1,"nokiaX20"));
        DeviceDAO.deviceDAO.add(new Device(deviceType2, deviceColor2,"Samsung345"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse("12/12/1999", formatter);
        LocalDate localDate1 = LocalDate.parse("04/10/1983", formatter);

        UserDAO.userDAO.add(new User("Alex","Alexov","Alexovich",localDate));
        UserDAO.userDAO.add(new User("Glex2","Alexov2","Alexovich2",localDate1));
        UserDAO.userDAO.add(new User("Alex","Alfxov","Alexovich3",LocalDate.now()));

        UserActivityDAO.userActivityDAO.add(new UserActivity(UserDAO.userDAO.get(0), DeviceDAO.deviceDAO.get(0),  LocalDate.now()));
        UserActivityDAO.userActivityDAO.add(new UserActivity(UserDAO.userDAO.get(1), DeviceDAO.deviceDAO.get(1),  LocalDate.now()));

        BaseView baseView = new BaseView();
        baseView.baseMenu();

    }
}
