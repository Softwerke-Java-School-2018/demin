package com.miros.testproject.controller.device;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.service.DeviceService;

import javax.rmi.CORBA.Util;

public class DeviceFindController extends BaseController {
    private DeviceService deviceService = new DeviceService();
    public Device findId(Integer id) {
        try {
            return deviceService.find(id);
        } catch (IndexOutOfBoundsException e) {
            utils.printLine(e.getMessage());
            waitForEnter();
            return null;
        }
    }
    public void findDeviceColor(String color) {
        if (!DeviceColor.getColorByString(color).equals(DeviceColor.NONE)) {
            deviceService
                    .findAll()
                    .filter(s -> s.getDeviceColor()
                            .name()
                            .equalsIgnoreCase(color))
                    .forEach(e -> utils.printLine(e));
        }
        waitForEnter();
    }
    public void findModel(String model) {
        deviceService
                .findAll()
                .filter(s -> s.getModel().equalsIgnoreCase(model))
                .forEach(e -> utils.printLine(e));
    }
    public void findDeviceType(String type) {
        DeviceType deviceType = DeviceType.getTypeByString(type);
        if(!deviceType.equals(DeviceType.NONE)){
            deviceService
                    .findAll()
                    .filter(s -> s.getDeviceType()
                            .name()
                            .equalsIgnoreCase(type))
                    .forEach(e -> utils.printLine(e));
        }
        waitForEnter();
    }
    public void showAll() {
        deviceService
                .findAll()
                .forEach(e->utils.printLine(e));
        waitForEnter();
    }
}
