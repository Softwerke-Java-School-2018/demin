package com.miros.testproject.controller.device;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.service.DeviceService;

public class DeviceFindController extends BaseController {
    private static DeviceFindController deviceFindController = new DeviceFindController();
    private static DeviceService deviceService = DeviceService.getInstance();

    public DeviceFindController(){}

    public static DeviceFindController getInstance(){
        return deviceFindController;
    }
    public Device idFind(Integer id){
        try {
            return deviceService.idFind(id);
        } catch (IndexOutOfBoundsException e){
            Utils.printLine(e.getMessage());
            waitForEnter();
        }
        return null;
    }
    public void deviceColorFind(String color){
        if(!DeviceColor.getColorByString(color).equals(DeviceColor.NONE)) {
            for (Device device : DeviceDAO.getInstance()) {
                if (device.getDeviceColor().name().equalsIgnoreCase(color)) {
                    System.out.println(device.toString());
                }
            }
            waitForEnter();
        }
    }
    public void modelFind(String name) {
        for (Device device : DeviceDAO.getInstance()){
            if(device.getModel().equals(name)){
                System.out.println(device.toString());
            }
        }
    }
    public void deviceTypeFind(String type){
        for (Device device : DeviceDAO.getInstance()){
            if(device.getDeviceType().name().equalsIgnoreCase(type)){
                System.out.println(device.toString());
            }
        }
        waitForEnter();
    }
    public void showAll(){
        for(Device device : DeviceDAO.getInstance()){
            System.out.println(device);
        }
        waitForEnter();
    }
}
