package com.miros.testproject.data.entity;

import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@ToString
@Builder
public class Device {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private int id;
    private DeviceType deviceType;
    private DeviceColor deviceColor;
    private String model;

    public Device(DeviceType deviceType, DeviceColor deviceColor, String model) {
        this.id = atomicInteger.incrementAndGet();
        this.deviceType = deviceType;
        this.deviceColor = deviceColor;
        this.model = model.toUpperCase();
    }

    public synchronized Device getDevice() {
        return this;
    }

    public int getId() {
        return atomicInteger.get();
    }
}
