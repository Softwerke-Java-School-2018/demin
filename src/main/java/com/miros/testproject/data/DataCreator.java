package com.miros.testproject.data;

import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.DAO.UserActivityDAO;
import com.miros.testproject.data.DAO.UserDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.data.entity.UserActivity;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataCreator {
    private  List<Device> deviceDAO = DeviceDAO.getInstance().getInstanceList();
    private  List<User> userDAO = UserDAO.getInstance().getInstanceList();
    private  List<UserActivity> userActivityDAO = UserActivityDAO.getInstance().getInstanceList();
    public void dataAdd(){
        DeviceType deviceType = DeviceType.LAPTOP;
        DeviceColor deviceColor = DeviceColor.BLACK;

        DeviceType deviceType1 = DeviceType.PHONE;
        DeviceColor deviceColor1 = DeviceColor.WHITE;

        DeviceType deviceType2 = DeviceType.TABLET;
        DeviceColor deviceColor2 = DeviceColor.BLACK;

        deviceDAO.add(new Device(deviceType, deviceColor,"asus7735"));
        deviceDAO.add(new Device(deviceType1, deviceColor1,"nokiaX20"));
        deviceDAO.add(new Device(deviceType2, deviceColor2,"Samsung345"));
        deviceDAO.add(new Device(deviceType, deviceColor,"asus33"));
        deviceDAO.add(new Device(deviceType1, deviceColor1,"nok"));
        deviceDAO.add(new Device(deviceType2, deviceColor2,"Samsu"));


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse("12/12/1999", formatter);
        LocalDate localDate1 = LocalDate.parse("04/10/1983", formatter);

        userDAO.add(new User("Sergey","Semenovv","Alexovich",localDate));
        userDAO.add(new User("Juri","Rusakov","Fedorovich",localDate1));
        userDAO.add(new User("Alex","Agafonof","Petrovich",LocalDate.now()));

        List<Device> deviceList = new ArrayList();
        List<Device> deviceList2 = new ArrayList();

        deviceList.add(deviceDAO.get(0));
        deviceList.add(deviceDAO.get(1));
        deviceList.add(deviceDAO.get(2));

        deviceList2.add(deviceDAO.get(1));
        deviceList2.add(deviceDAO.get(2));
        deviceList2.add(deviceDAO.get(4));
        deviceList2.add(deviceDAO.get(5));

        userActivityDAO.add(new UserActivity(userDAO.get(0), deviceList,  LocalDate.now()));
        userActivityDAO.add(new UserActivity(userDAO.get(1), deviceList,  LocalDate.now()));
        userActivityDAO.add(new UserActivity(userDAO.get(2), deviceList2,  LocalDate.now()));
    }
}
