package com.miros.testproject.controller.device;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.exception.RuntimeEx;
import com.miros.testproject.service.BaseClassService;
import com.miros.testproject.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Controller for Create, Delete, Update Device Entity
 */
public class DeviceController extends BaseController {
    private DeviceService deviceService = BaseClassService.getInstance().getDeviceService();
    private final static Logger log = LoggerFactory.getLogger(DeviceController.class);
    private volatile Device device;

    public Optional<Device> create(String type, String color, String devModel) {
        DeviceType devType = DeviceType.getTypeByString(type);
        DeviceColor devColor = DeviceColor.getColorByString(color);
        if (devColor.equals(DeviceColor.NONE)) {
            log.info("Device create: Doesn't exist color " + color);
            utils.printLine("This color of device, doesn't exist");
            waitForEnter();
        }
        if (devType.equals(DeviceType.NONE)) {
            log.info("Device create: Doesn't exist type " + type);
            utils.printLine("This type of device, doesn't exist");
            waitForEnter();
        }
        try {
            device = Device.builder()
                    .setType(devType)
                    .setColor(devColor)
                    .setModel(devModel)
                    .build();
            deviceService.save(device);
            log.info("Device create: Device created" + device.getId());
            utils.printLine("Device created");
            waitForEnter();
            return Optional.of(device);
        } catch (RuntimeEx e) {
            log.info("Device create: Runtime err", e);
            waitForEnter();
        } catch (Exception e) {
            log.info("Device create: Exception err", e);
            waitForEnter();
        }
        return empty;
    }

    public Optional<Device> delete(int id) {
        try {
            device = deviceService.delete(id);
            utils.printLine("Device deleted");
            log.info("Device delete: device deleted id: " + id);
            waitForEnter();
            return Optional.of(device);
        } catch (RuntimeEx e) {
            log.info("Device delete: not existing Id");
            utils.printLine("Device with " + id + " id number, doesn't exist");
            waitForEnter();
        }
        return empty;
    }

    public Optional<Device> update(int id, String type, String color, String model) {
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
            device.setDeviceType(deviceType);
            device.setDeviceColor(deviceColor);
            if (!model.equals("")) {
                deviceService
                        .find(id)
                        .setModel(model);
            }
            utils.printLine("Device updated!");
            waitForEnter();
        } catch (RuntimeEx e) {
            log.info("Update: device doesnt exist, id: " + id, e);
            utils.printLine("Device with " + id + " id number, doesn't exist");
            waitForEnter();
        }
        return empty;
    }
}













