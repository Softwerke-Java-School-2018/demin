package com.miros.testproject.controller.device;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.sort.SortClass;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.exception.RuntimeEx;
import com.miros.testproject.service.BaseClassService;
import com.miros.testproject.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for find Device elements
 */
public class DeviceFindController extends BaseController {
    private DeviceService deviceService = BaseClassService.getInstance().getDeviceService();
    private SortClass sortClass = SortClass.getInstance();
    private List<Device> deviceList;
    private static final Logger log = LoggerFactory.getLogger(DeviceFindController.class);

    public void findId(Integer id) {
        try {
            utils.printLine(deviceService.find(id));
            log.info("Device find: Device with id: " + id);
            waitForEnter();
        } catch (RuntimeEx e) {
            utils.printLine(e.getMessage());
            waitForEnter();
        }
    }

    public void findColor(String color) {
        DeviceColor deviceColor = DeviceColor.getColorByString(color);
        if (!deviceColor.equals(DeviceColor.NONE)) {
            try {
                deviceList = deviceService
                        .findAll()
                        .filter(s -> s.getDeviceColor()
                                .name()
                                .equalsIgnoreCase(color))
                        .collect(Collectors.toList());
                log.info("Device find: Devices with color " + deviceColor + "\n"
                        + deviceList);
                deviceList.forEach(s -> utils.printLine(s));
            } catch (RuntimeEx e) {
                log.info("Device find: err by trying find color: " + deviceColor, e);
                waitForEnter();
            }
        }
        sortClass.sortFunc(DeviceFindController.class, deviceList);
    }

    public void findModel(String model) {
        deviceList = deviceService
                .findAll()
                .filter(s -> s.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
        deviceList.forEach(s -> utils.printLine(s));
        sortClass.sortFunc(DeviceFindController.class, deviceList);
    }

    public void findDeviceType(String type) {
        DeviceType deviceType = DeviceType.getTypeByString(type);
        if (!deviceType.equals(DeviceType.NONE)) {
            deviceList = deviceService
                    .findAll()
                    .filter(s -> s.getDeviceType()
                            .name()
                            .equalsIgnoreCase(type))
                    .collect(Collectors.toList());
            deviceList.forEach(s -> utils.printLine(s));
        }
        sortClass.sortFunc(DeviceFindController.class, deviceList);
    }

    public void showAll() {
        deviceList = deviceService
                .findAll()
                .collect(Collectors.toList());
        deviceList
                .forEach(utils::printLine);
        sortClass.sortFunc(DeviceFindController.class, deviceList);
    }
}
