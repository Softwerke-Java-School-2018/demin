package com.miros.testproject.controller.device;

import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.service.DeviceService;

import java.util.List;
import java.util.stream.Collectors;

public class DeviceFindController extends BaseClassController {
    private DeviceService deviceService = new DeviceService();
    private List<Device> temDeviceDAO = tempDataService.getTempDAODeviceList();
    private List<Device> deviceList;

    public void findId(Integer id) {
        try {
            utils.printLine(deviceService.find(id));
            waitForEnter();
        } catch (IndexOutOfBoundsException e) {
            utils.printLine(e.getMessage());
            waitForEnter();
        }
    }

    public void findDeviceColor(String color) {
        if (!DeviceColor.getColorByString(color).equals(DeviceColor.NONE)) {
            deviceList = deviceService
                    .findAll()
                    .filter(s -> s.getDeviceColor()
                            .name()
                            .equalsIgnoreCase(color))
                    .collect(Collectors.toList());
            deviceList.forEach(s -> utils.printLine(s));
        }
        temDeviceDAO.clear();
        temDeviceDAO.addAll(deviceList);
        utils.sortFunc(deviceFindController);

    }

    public void findModel(String model) {
        deviceList = deviceService
                .findAll()
                .filter(s -> s.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
        deviceList.forEach(s -> utils.printLine(s));
        temDeviceDAO.clear();
        temDeviceDAO.addAll(deviceList);
        utils.sortFunc(deviceFindController);
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
        temDeviceDAO.clear();
        temDeviceDAO.addAll(deviceList);
        utils.sortFunc(deviceFindController);
    }

    public void showAll() {
        deviceList = deviceService
                .findAll()
                .collect(Collectors.toList());
        deviceList
                .forEach(utils::printLine);
        temDeviceDAO.clear();
        temDeviceDAO.addAll(deviceList);
        utils.sortFunc(deviceFindController);
    }
}
