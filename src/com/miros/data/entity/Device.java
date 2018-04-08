package com.miros.data.entity;

import com.miros.data.enums.DeviceColor;
import com.miros.data.enums.DeviceType;

public class Device {

    private static long deviceId=0;
    private long id;
    DeviceType deviceType;
    DeviceColor deviceColor;

    public Device(){};

    public Device(DeviceType deviceType, DeviceColor deviceColor){
        this.id = deviceId++;
        this.deviceType = deviceType;
        this.deviceColor = deviceColor;
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
}
