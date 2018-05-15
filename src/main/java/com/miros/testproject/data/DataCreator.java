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
    private List<Device> deviceDAO = DeviceDAO.getInstance().getDeviceList();
    private List<User> userDAO = UserDAO.getInstance().getInstanceList();
    private List<UserActivity> userActivityDAO = UserActivityDAO.getInstance().getInstanceList();

    public void dataAdd() {
        DeviceType deviceType = DeviceType.LAPTOP;
        DeviceColor deviceColor = DeviceColor.BLACK;

        DeviceType deviceType1 = DeviceType.PHONE;
        DeviceColor deviceColor1 = DeviceColor.WHITE;

        DeviceType deviceType2 = DeviceType.TABLET;
        DeviceColor deviceColor2 = DeviceColor.BLACK;

        Device device1 = Device.builder()
                .setType(deviceType)
                .setColor(deviceColor)
                .setModel("asus7735")
                .build();
        Device device2 = Device.builder()
                .setType(deviceType1)
                .setColor(deviceColor1)
                .setModel("asus771")
                .build();
        Device device3 = Device.builder()
                .setType(deviceType2)
                .setColor(deviceColor2)
                .setModel("asus75")
                .build();
        Device device4 = Device.builder()
                .setType(deviceType)
                .setColor(deviceColor)
                .setModel("asu")
                .build();
        Device device5 = Device.builder()
                .setType(deviceType1)
                .setColor(deviceColor1)
                .setModel("asuqwe")
                .build();


        deviceDAO.add(device1);
        deviceDAO.add(device2);
        deviceDAO.add(device3);
        deviceDAO.add(device4);
        deviceDAO.add(device5);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse("12/12/1999", formatter);
        LocalDate localDate1 = LocalDate.parse("04/10/1983", formatter);

        User user = User.builder()
                .setName("Sergey")
                .setSurname("Semenovv")
                .setPatronymic("Alexovich")
                .setBirthDay(localDate)
                .build();

        User user2 = User.builder()
                .setName("Juri")
                .setSurname("Rusakov")
                .setPatronymic("Fedorovich")
                .setBirthDay(localDate1)
                .build();

        User user3 = User.builder()
                .setName("Alex")
                .setSurname("Agafonof")
                .setPatronymic("Petrovich")
                .setBirthDay(LocalDate.now())
                .build();

        User user4 = User.builder()
                .setName("Alex3")
                .setSurname("Agafonof123")
                .setPatronymic("Petrovich12")
                .setBirthDay(LocalDate.now())
                .build();

        User user5 = User.builder()
                .setName("Alex4")
                .setSurname("qwerty")
                .setPatronymic("Petrov")
                .setBirthDay(LocalDate.now())
                .build();

        userDAO.add(user);
        userDAO.add(user2);
        userDAO.add(user3);
        userDAO.add(user4);
        userDAO.add(user5);

        List<Device> deviceList = new ArrayList();
        List<Device> deviceList2 = new ArrayList();

        deviceList.add(deviceDAO.get(0));
        deviceList.add(deviceDAO.get(1));
        deviceList.add(deviceDAO.get(2));

        deviceList2.add(deviceDAO.get(0));
        deviceList2.add(deviceDAO.get(1));
        deviceList2.add(deviceDAO.get(2));
        deviceList2.add(deviceDAO.get(3));

        UserActivity userActivity = UserActivity.builder()
                .setUser(userDAO.get(0))
                .setDeviceList(deviceList)
                .setDate(LocalDate.now())
                .build();

        UserActivity userActivity1 = UserActivity.builder()
                .setUser(userDAO.get(1))
                .setDeviceList(deviceList)
                .setDate(LocalDate.now())
                .build();

        UserActivity userActivity2 = UserActivity.builder()
                .setUser(userDAO.get(2))
                .setDeviceList(deviceList)
                .setDate(LocalDate.now())
                .build();

        userActivityDAO.add(userActivity);
        userActivityDAO.add(userActivity1);
        userActivityDAO.add(userActivity2);
    }
}
