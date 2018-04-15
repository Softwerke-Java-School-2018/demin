package com.miros;

import com.miros.data.DAO.DeviceDAO;
import com.miros.data.DAO.UserActivityDAO;
import com.miros.data.DAO.UserDAO;
import com.miros.data.entity.Device;
import com.miros.data.entity.User;
import com.miros.data.entity.UserActivity;
import com.miros.data.enums.DeviceColor;
import com.miros.data.enums.DeviceType;
import com.miros.view.BaseView;


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
