package com.miros.testproject.data.entity;

import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeviceTest {

    private Device device;
    private DeviceColor deviceColor = DeviceColor.BLACK;
    private DeviceType deviceType = DeviceType.PHONE;
    private String deviceModel = "Nokia44567";

    private Device testDevice;
    private DeviceColor testDeviceColor = DeviceColor.WHITE;
    private DeviceType testDeviceType = DeviceType.LAPTOP;
    private String testDeviceModel = "Noki";

    @Before
    public void init() {
        device = Device.builder()
                .setColor(deviceColor)
                .setModel(deviceModel)
                .setType(deviceType)
                .build();
    }


    @Test
    public void getters_setters_success() {
        testDevice = device.getDevice();
        testDevice.setDeviceType(testDeviceType);
        testDevice.setDeviceColor(testDeviceColor);
        testDevice.setModel(testDeviceModel);

        Assert.assertEquals(Device.class, testDevice.getClass());
        Assert.assertEquals(device.getId(), testDevice.getId());
        Assert.assertEquals(testDeviceType, testDevice.getDeviceType());
        Assert.assertEquals(testDeviceColor, testDevice.getDeviceColor());
        Assert.assertEquals(testDeviceModel, testDevice.getModel());
    }
}