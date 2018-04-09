package com.miros;

import com.miros.data.entity.Device;
import com.miros.data.entity.User;
import com.miros.data.entity.UserActivity;
import com.miros.data.enums.DeviceColor;
import com.miros.data.enums.DeviceType;
import com.miros.view.BaseView;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import  java.util.List;

public class Main {
    /**
     * Каталоги Пользователей, Устройств и Истории покупок
     */
    public static List<User> userList = new ArrayList();
    public static List<Device> deviceList = new ArrayList();
    public static List<UserActivity> userActivityList = new ArrayList();

    public static void main(String[] args) {


        DeviceType deviceType = DeviceType.LAPTOP;
        DeviceColor deviceColor = DeviceColor.BLACK;

        DeviceType deviceType1 = DeviceType.PHONE;
        DeviceColor deviceColor1 = DeviceColor.WHITE;

        DeviceType deviceType2 = DeviceType.TABLET;
        DeviceColor deviceColor2 = DeviceColor.BLACK;

        deviceList.add(new Device(deviceType, deviceColor,"asus7735"));
        deviceList.add(new Device(deviceType1, deviceColor1,"nokiaX20"));
        deviceList.add(new Device(deviceType2, deviceColor2,"Samsung345"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse("12/12/1999", formatter);
        LocalDate localDate1 = LocalDate.parse("04/10/1983", formatter);

        userList.add(new User("Alex","Alexov","Alexovich",localDate));
        userList.add(new User("Alex2","Alexov2","Alexovich2",localDate1));
        userList.add(new User("Alex3","Alexov3","Alexovich3",LocalDate.now()));

        userActivityList.add(new UserActivity(userList.get(0), deviceList.get(0),  LocalDate.now()));
        userActivityList.add(new UserActivity(userList.get(1), deviceList.get(1),  LocalDate.now()));

        BaseView baseView = new BaseView();
        baseView.baseMenu();
    }
}
