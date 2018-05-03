package com.miros.testproject.controller.device;

import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.service.DeviceService;

public class DeviceController extends BaseClassController {
    private DeviceService deviceService = new DeviceService();

    public void create(String type, String color, String model) {
        DeviceType devType = DeviceType.getTypeByString(type);
        DeviceColor devColor = DeviceColor.getColorByString(color);
        if (devColor.equals(DeviceColor.NONE)) {
            utils.printLine("This color of device, doesn't exist");
            waitForEnter();
        }
        if (devType.equals(DeviceType.NONE)) {
            utils.printLine("This type of device, doesn't exist");
            waitForEnter();
        }
        deviceService.save(new Device(devType, devColor, model));
        utils.printLine("Device created");
        waitForEnter();
    }

    public void delete(int id) {
        try {
            deviceService.delete(id);
            utils.printLine("Device deleted");
            waitForEnter();
        } catch (IndexOutOfBoundsException e) {
            utils.printLine("Device with " + id + " id number, doesn't exist");
            waitForEnter();
        }
    }

    public void update(int id, String type, String color, String model) {
        try {
            Device device = deviceService.find(id);
            DeviceType deviceType = DeviceType.getTypeByString(type);
            DeviceColor deviceColor = DeviceColor.getColorByString(color);
            if (!type.equals("")) {
                if (deviceType.equals(DeviceType.NONE)) {
                    utils.printLine("This type of device, doesn't exist");
                    waitForEnter();
                }
            }
            if (!color.equals("")) {
                if (deviceColor.equals(DeviceColor.NONE)) {
                    utils.printLine("This color of device, doesn't exist");
                    waitForEnter();
                }
            }
            device.setDeviceType(deviceType);
            device.setDeviceColor(deviceColor);
            if (!model.equals("")) {
                deviceService
                        .find(id)
                        .setModel(model);
            }
        } catch (IndexOutOfBoundsException e) {
            utils.printLine("Device with " + id + " id number, doesn't exist");
            waitForEnter();
        }
        utils.printLine("Device updated!");
        waitForEnter();
    }

}













