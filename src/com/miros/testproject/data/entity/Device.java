package com.miros.testproject.data.entity;

import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;

public class Device {
    private static int deviceId = 0;
    private int id;
    private DeviceType deviceType;
    private DeviceColor deviceColor;
    private String model;

    public Device(DeviceType deviceType, DeviceColor deviceColor, String model) {
        this.id = deviceId++;
        this.deviceType = deviceType;
        this.deviceColor = deviceColor;
        this.model = model.toUpperCase();
    }

    public void setDeviceColor(DeviceColor deviceColor) {
        this.deviceColor = deviceColor;
    }
    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
    public DeviceColor getDeviceColor() {
        return deviceColor;
    }
    public DeviceType getDeviceType() {
        return deviceType;
    }
    public int getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString() {
        return id + " " + deviceType.toString() + " " + deviceColor.toString() + " " + model;
    }
}
