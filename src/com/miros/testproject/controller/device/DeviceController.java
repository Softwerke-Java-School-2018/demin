package com.miros.testproject.controller.device;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.service.DeviceService;

public class DeviceController extends BaseController {
    private static DeviceController deviceController = new DeviceController();
    private static  DeviceService deviceService = DeviceService.getInstance();

    public DeviceService getDeviceService(){
        return DeviceService.getInstance();
    }
    public static DeviceController getInstance() {
        return deviceController;
    }

    public DeviceController() {
    }

    public void create(String type, String color, String model) {
        DeviceType devType = DeviceType.getTypeByString(type);
        DeviceColor devColor = DeviceColor.getColorByString(color);
        if (devColor.equals(DeviceColor.NONE)) {
            Utils.printLine("This color of device, doesn't exist");
            waitForEnter();
        }
        if (devType.equals(DeviceType.NONE)) {
            Utils.printLine("This type of device, doesn't exist");
            waitForEnter();
        }
        DeviceDAO.getInstance().add(new Device(devType, devColor, model));
        Utils.printLine("Device created");
        waitForEnter();
    }

    public void delete(Integer id) {
        try {
            Device device = DeviceDAO.getInstance().get(id);
            DeviceDAO.getInstance().remove(device);
            Utils.printLine("Device deleted");
            waitForEnter();
        } catch (IndexOutOfBoundsException e) {
            Utils.printLine("Device with " + id + " id number, doesn't exist");
            waitForEnter();
        }
    }

    public void update(int id, String type, String color, String model) {
        try {
            Device device = DeviceDAO.getInstance().get(id);
            DeviceType deviceType = DeviceType.getTypeByString(type);
            DeviceColor deviceColor = DeviceColor.getColorByString(color);
            if (!type.equals("")) {
                if (deviceType.equals(DeviceType.NONE)) {
                    Utils.printLine("This type of device, doesn't exist");
                    waitForEnter();
                }
            }
            if (!color.equals("")) {
                if (deviceColor.equals(DeviceColor.NONE)) {
                    Utils.printLine("This color of device, doesn't exist");
                    waitForEnter();
                }
            }
            device.setDeviceType(deviceType);
            device.setDeviceColor(deviceColor);
            if (!model.equals("")) {
                DeviceDAO.getInstance().get(id).setModel(model);
            }
        } catch (IndexOutOfBoundsException e) {
            Utils.printLine("Device with " + id + " id number, doesn't exist");
            waitForEnter();
        }
        waitForEnter();
    }

    public boolean exist(int id){
        return deviceService.exist(id);
    }
}













