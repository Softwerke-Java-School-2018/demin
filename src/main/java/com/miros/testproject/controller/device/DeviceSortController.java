package com.miros.testproject.controller.device;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.sort.SortClass;
import com.miros.testproject.controller.sort.device.DeviceColorComparator;
import com.miros.testproject.controller.sort.device.DeviceModelComparator;
import com.miros.testproject.controller.sort.device.DeviceTypeComparator;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.view.SortView;

import java.util.List;

/**
 * Controller for sort Device elements
 */
public class DeviceSortController extends BaseController {
    private SortClass sortClass = SortClass.getInstance();

    public void sortModel(List<Device> deviceList) {
        deviceList.stream()
                .sorted(new DeviceModelComparator())
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(DeviceFindController.class, deviceList);
    }

    public void sortColor(List<Device> deviceList) {
        deviceList.stream()
                .sorted(new DeviceColorComparator())
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(DeviceFindController.class, deviceList);
    }

    public void sortType(List<Device> deviceList) {
        deviceList.stream()
                .sorted(new DeviceTypeComparator())
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(DeviceFindController.class, deviceList);
    }
}
