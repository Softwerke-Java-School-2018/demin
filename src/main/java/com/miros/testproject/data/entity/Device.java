package com.miros.testproject.data.entity;

import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@ToString
public class Device {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private int id;
    private DeviceType deviceType;
    private DeviceColor deviceColor;
    private String model;

    public Device(Builder deviceBuilder) {
        this.id = atomicInteger.incrementAndGet();
        this.deviceType = deviceBuilder.type;
        this.deviceColor = deviceBuilder.color;
        this.model = deviceBuilder.model;
    }

    public synchronized Device getDevice() {
        return this;
    }

    public int getId() {
        return this.id;
    }

    public static Builder builder() {
        return new Device.Builder();
    }

    public static void refreshAtomicInteger(){
        atomicInteger.set(0);
    }

    public static class Builder {
        private DeviceType type;
        private DeviceColor color;
        private String model;

        public Builder setType(DeviceType deviceType) {
            Optional<DeviceType> optType = Optional.of(deviceType);
            if (optType.isPresent()) {
                this.type = optType.get();
                return this;
            }
            this.type = DeviceType.NONE;
            return this;
        }

        public Builder setColor(DeviceColor color) {
            Optional<DeviceColor> optColor = Optional.of(color);
            if (optColor.isPresent()) {
                this.color = optColor.get();
                return this;
            }
            this.color = DeviceColor.NONE;
            return this;
        }

        public Builder setModel(String model) {
            Optional<String> optModel = Optional.of(model);
            if (!optModel.isPresent()) {
                throw new NullPointerException("Model is null");
            }
            this.model = optModel.get();
            return this;
        }

        public Device build() {
            return new Device(this);
        }
    }

}
