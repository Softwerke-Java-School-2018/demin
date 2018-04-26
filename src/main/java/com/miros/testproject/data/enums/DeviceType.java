package com.miros.testproject.data.enums;

public enum DeviceType {
    PHONE, TABLET, LAPTOP, PLAYER, NONE;

    public static DeviceType getTypeByString(String color) {
        for (DeviceType deviceType : values()) {
            if (deviceType.name().equalsIgnoreCase(color)) {
                return deviceType;
            }
        }
        return NONE;
    }
}
