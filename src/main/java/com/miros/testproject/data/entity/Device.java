package com.miros.testproject.data.entity;

import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
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
}
