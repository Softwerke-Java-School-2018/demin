package com.miros.testproject.data.enums;

public enum DeviceColor {
    BLACK,
    WHITE,
    NONE;

    public static DeviceColor getColorByString(String color) {
        for (DeviceColor deviceColor : values()) {
            if (deviceColor.name().equalsIgnoreCase(color)) {
                return deviceColor;
            }
        }
        return NONE;
    }
}
