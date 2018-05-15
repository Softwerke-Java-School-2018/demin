package com.miros.testproject.controller.device;

import com.miros.testproject.data.DataCreator;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.service.BaseClassService;
import com.miros.testproject.service.DeviceService;
import com.miros.testproject.service.UserActivityService;
import com.miros.testproject.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import static org.junit.Assert.*;

public class DeviceControllerTest {
    private DeviceFindController deviceFindController = new DeviceFindController();
    private DeviceController deviceController = new DeviceController();
    private DeviceService deviceService = new DeviceService();
    private DeviceType enumType;
    private DeviceColor enumColor;
    private String model;

    private UserService userService;
    private UserActivityService userActivityService;

    private String type1;
    private String color1;
    private String model1;

    private Device device;
    private ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());

    @Before
    public void init() {
        deviceService = BaseClassService.getInstance().getDeviceService();
        userService = BaseClassService.getInstance().getUserService();
        userActivityService = BaseClassService.getInstance().getUserActivityService();

        enumType = DeviceType.PLAYER;
        enumColor = DeviceColor.BLACK;
        model = "qwer";
        type1 = "PLAYER";
        color1 = "BLACK";
        model1 = "qwer";

        DataCreator dataCreator = new DataCreator();
        dataCreator.dataAdd();
    }

    @Test
    public void device_Find() {
        device = Device.builder()
                .setType(enumType)
                .setColor(enumColor)
                .setModel(model)
                .build();
        deviceService.save(device);
    }

    @Test
    public void create_Device_Controller() {
       /* Optional<Device> device = deviceController.create(type1, color1, model1);
        System.setIn(in);
        Assert.assertNotNull(device);
        Assert.assertNotNull(device.get());
        Device deviceBuild = Device.builder()
                .setType(enumType)
                .setColor(enumColor)
                .setModel(model1)
                .build();
        Assert.assertEquals(device.get(), deviceBuild);
        */
    }

    @After
    public void finish() {
        deviceService.clear();
        userService.clear();
        userActivityService.clear();
    }
}