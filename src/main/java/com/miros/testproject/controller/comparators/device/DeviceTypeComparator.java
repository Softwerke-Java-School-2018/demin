package com.miros.testproject.controller.comparators.device;

import com.miros.testproject.data.entity.Device;

import java.util.Comparator;

public class DeviceTypeComparator implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2) {
        return o1.getDeviceType().toString().compareTo(o2.getDeviceType().toString());
    }
}
