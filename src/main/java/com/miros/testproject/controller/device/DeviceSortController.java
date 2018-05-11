package com.miros.testproject.controller.device;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.sort.SortClass;
import com.miros.testproject.controller.sort.device.DeviceColorComparator;
import com.miros.testproject.controller.sort.device.DeviceModelComparator;
import com.miros.testproject.controller.sort.device.DeviceTypeComparator;
import com.miros.testproject.data.entity.Device;

import java.util.stream.Stream;

/**
 * Controller for sort Device elements
 */
public class DeviceSortController extends BaseController {
    private SortClass sortClass = SortClass.getInstance();

    public void sortModel(Stream<Device> deviceStream) {
        deviceStream = deviceStream.sorted(new DeviceModelComparator());
        deviceStream
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(DeviceFindController.class, deviceStream);
    }

    public void sortColor(Stream<Device> deviceStream) {
        deviceStream = deviceStream.sorted(new DeviceColorComparator());
        deviceStream
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(DeviceFindController.class, deviceStream);
    }

    public void sortType(Stream<Device> deviceStream) {
        deviceStream = deviceStream.sorted(new DeviceTypeComparator());
        deviceStream
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(DeviceFindController.class, deviceStream);
    }
}
