package com.miros.testproject.controller.device;


import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.controller.comparators.device.DeviceColorComparator;
import com.miros.testproject.controller.comparators.device.DeviceModelComparator;
import com.miros.testproject.controller.comparators.device.DeviceTypeComparator;
import com.miros.testproject.data.entity.Device;

import java.util.List;
import java.util.Collections;

public class DeviceSortController extends BaseClassController {
    List<Device> tempDeviceDAO = tempDataService.getTempDAODeviceList();


    public void sortByModel() {
        comparator = new DeviceModelComparator();
        Collections.sort(tempDeviceDAO, comparator);
        refreshTempList();
        tempDeviceDAO
                .forEach(s -> utils.printLine(s));
        utils.sortFunc(deviceFindController);
    }

    public void sortByColor() {
        comparator = new DeviceColorComparator();
        Collections.sort(tempDeviceDAO, comparator);
        refreshTempList();
        tempDeviceDAO
                .forEach(s -> utils.printLine(s));
        waitForEnter();
    }

    public void sortByType() {
        comparator = new DeviceTypeComparator();
        Collections.sort(tempDeviceDAO, comparator);
        refreshTempList();
        tempDeviceDAO
                .forEach(s -> utils.printLine(s));
        waitForEnter();
    }

    public void refreshTempList() {
    }
}
