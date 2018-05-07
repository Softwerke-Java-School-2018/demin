package com.miros.testproject.controller.device;

import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.exception.RuntimeEx;
import com.miros.testproject.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DeviceController extends BaseClassController {
    private DeviceService deviceService = new DeviceService();
    private final static Logger log = LoggerFactory.getLogger(DeviceController.class);


    public void create(String type, String color, String model) {
        DeviceType devType = DeviceType.getTypeByString(type);
        DeviceColor devColor = DeviceColor.getColorByString(color);
        if (devColor.equals(DeviceColor.NONE)) {
            log.info("Device create: Is not existing color " + color);
            utils.printLine("This color of device, doesn't exist");
            waitForEnter();
        }
        if (devType.equals(DeviceType.NONE)) {
            log.info("Device create: Is no existing type " + type);
            utils.printLine("This type of device, doesn't exist");
            waitForEnter();
        }
        try {
            Device device = Device.builder()
                    .deviceType(devType)
                    .deviceColor(devColor)
                    .build();
            deviceService.save(device);
            utils.printLine("Device created");
        } catch (RuntimeEx e) {
            log.info("Device create Runtime err", e);
            waitForEnter();
        } catch (Exception e) {
            log.info("Device create Exception err", e);
            waitForEnter();
        }
    }

    public void delete(int id) {
        try {
            deviceService.delete(id);
            utils.printLine("Device deleted");
            log.info("Device delete: device deleted id: " + id);
            waitForEnter();
        } catch (RuntimeEx e) {
            log.info("Device delete: not existing Id", e);
            utils.printLine("Device with " + id + " id number, doesn't exist");
            waitForEnter();
        }
    }

    public void update(int id, String type, String color, String model) {
        try {
            Device device = deviceService.find(id);
            DeviceType deviceType = DeviceType.getTypeByString(type);
            DeviceColor deviceColor = DeviceColor.getColorByString(color);
            if (!"".equals(type)) {
                if (deviceType.equals(DeviceType.NONE)) {
                    utils.printLine("This type of device, doesn't exist");
                    waitForEnter();
                }
            }
            if (!"".equals(color)) {
                if (deviceColor.equals(DeviceColor.NONE)) {
                    utils.printLine("This color of device, doesn't exist");
                    waitForEnter();
                }
            }
            device.builder()
                    .deviceType(deviceType)
                    .deviceColor(deviceColor)
                    .build();
            device.setDeviceColor(deviceColor);
            if (!model.equals("")) {
                deviceService
                        .find(id)
                        .setModel(model);
            }
        } catch (RuntimeEx e) {
            log.info("Update: device doesnt exist, id: " + id, e);
            utils.printLine("Device with " + id + " id number, doesn't exist");
            waitForEnter();
        }
        utils.printLine("Device updated!");
        waitForEnter();
    }
}













