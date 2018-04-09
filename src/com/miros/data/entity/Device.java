package com.miros.data.entity;

import com.miros.data.enums.DeviceColor;
import com.miros.data.enums.DeviceType;

public class Device {

    private static long deviceId=0;
    private long id;

    private DeviceType deviceType;

    private DeviceColor deviceColor;

    private String model;

    public Device(){}

    public Device(DeviceType deviceType, DeviceColor deviceColor, String model){
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

    public long getId() {
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
        return id + " "+deviceType.toString()+" "+deviceColor.toString()+" "+model;
    }
}
