package com.miros.testproject.data.entity;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserActivityTest {
    private Device device;
    private DeviceColor deviceColor = DeviceColor.BLACK;
    private DeviceType deviceType = DeviceType.PHONE;
    private String deviceModel = "Nokia44567";

    private Device testDevice;
    private DeviceColor testDeviceColor = DeviceColor.WHITE;
    private DeviceType testDeviceType = DeviceType.LAPTOP;
    private String testDeviceModel = "Noki";

    private User user;
    private String userName = "userName";
    private String userSurname = "userSurname";
    private String userPatronymic = "userPatronymic";

    private User testUser;
    private String testUserName = "testUserName";
    private String testUserSurname = "testUserSurname";
    private String testUserPatronymic = "testUserPatronymic";

    private LocalDate date = LocalDate.now();
    private LocalDate testDate = BaseController.dateParser("09/11/1997");
    private List<Device> deviceList = new ArrayList();
    private List<Device> testDeviceList = new ArrayList();

    private UserActivity userActivity;

    @Before
    public void init() {
        device = Device.builder()
                .setColor(deviceColor)
                .setModel(deviceModel)
                .setType(deviceType)
                .build();


        deviceList.add(device);
        deviceList.add(device);

        testDevice = Device.builder()
                .setColor(testDeviceColor)
                .setType(testDeviceType)
                .setModel(testDeviceModel)
                .build();

        testDeviceList.add(testDevice);
        testDeviceList.add(testDevice);

        user = User.builder()
                .setName(userName)
                .setSurname(userSurname)
                .setPatronymic(userPatronymic)
                .setBirthDay(date)
                .build();

        testUser = User.builder()
                .setName(testUserName)
                .setSurname(testUserSurname)
                .setPatronymic(testUserPatronymic)
                .setBirthDay(date)
                .build();

        userActivity = UserActivity.builder()
                .setUser(user)
                .setDeviceList(deviceList)
                .setDate(date)
                .build();
    }

    @Test
    public void getters_setters_success() {
        UserActivity testUserActivity = userActivity.getUserActivity();

        testUserActivity.setDate(testDate);
        testUserActivity.setUser(testUser);
        testUserActivity.setDeviceList(testDeviceList);
        testUserActivity.setDate(testDate);

        Assert.assertEquals(userActivity.getClass(), testUserActivity.getClass());
        Assert.assertEquals(testDeviceList, testUserActivity.getDeviceList());
        Assert.assertEquals(testUser, testUserActivity.getUser());
        Assert.assertEquals(testDate, testUserActivity.getDate());
    }

    @Test
    public void getters_setters_null() {
        UserActivity testUserActivity = userActivity.getUserActivity();

        testUserActivity.setDate(null);
        testUserActivity.setUser(null);
        testUserActivity.setDeviceList(null);
        testUserActivity.setDate(null);

        Assert.assertEquals(userActivity.getClass(), testUserActivity.getClass());
        Assert.assertEquals(null, testUserActivity.getDeviceList());
        Assert.assertEquals(null, testUserActivity.getUser());
        Assert.assertEquals(null, testUserActivity.getDate());
    }
}