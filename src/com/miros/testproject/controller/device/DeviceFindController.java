package com.miros.testproject.controller.device;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;

public class DeviceFindController extends BaseController {
    private static DeviceFindController deviceFindController = new DeviceFindController();
    public DeviceFindController(){}

    public static DeviceFindController getInstance(){
        return deviceFindController;
    }
    public void idFind(Integer id){
        System.out.println();
        waitForEnter();
    }

    public void deviceColorFind(String color){
        if(!DeviceColor.getColorByString(color).equals(DeviceColor.NONE)) {
            for (Device device : DeviceDAO.deviceDAO) {
                if (device.getDeviceColor().name().equalsIgnoreCase(color)) {
                    System.out.println(device.toString());
                }
            }
            waitForEnter();
        }
    }

    public void modelFind(String name) {
        for (Device device : DeviceDAO.deviceDAO){
            if(device.getModel().equals(name)){
                System.out.println(device.toString());
            }
        }
    }


    public void deviceTypeFind(String type){
        for (Device device : DeviceDAO.deviceDAO){
            if(device.getDeviceType().name().equalsIgnoreCase(type)){
                System.out.println(device.toString());
            }
        }
        waitForEnter();
    }

    public void showAll(){
        for(Device device : DeviceDAO.deviceDAO){
            System.out.println(device);
        }
        waitForEnter();
    }
}
