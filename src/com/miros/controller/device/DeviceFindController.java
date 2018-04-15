package com.miros.controller.device;

import com.miros.controller.BaseController;
import com.miros.data.DAO.DeviceDAO;
import com.miros.data.entity.Device;
import com.miros.data.enums.DeviceColor;

/**
 * Контроллер для поиска устройств
 */
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
    /**
     * Поиск по цвету устройства
     * @param color
     */
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

    public void nameFind(String name) {
        for (Device device : DeviceDAO.deviceDAO){
            if(device.getModel().equals(name)){
                System.out.println(device.toString());
            }
        }
    }

    /**
     * Поиск по типу устройства
     * @param type
     */
    public void deviceTypeFind(String type){
        for (Device device : DeviceDAO.deviceDAO){
            if(device.getDeviceType().name().equalsIgnoreCase(type)){
                System.out.println(device.toString());
            }
        }
        waitForEnter();
    }
    /**
     * Вывод всех устройств
     */
    public void showAll(){
        for(Device device : DeviceDAO.deviceDAO){
            System.out.println(device);
        }
        waitForEnter();
    }
}
