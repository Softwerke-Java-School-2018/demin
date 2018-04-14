package com.miros.controller;

import com.miros.Main;
import com.miros.data.DateBase;
import com.miros.data.entity.Device;

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
        System.out.println(DateBase.deviceList.get(id));
        waitForEnter();
    }

    /**
     * Поиск по цвету устройства
     * @param color
     */
    public void deviceColorFind(String color){
            for (Device device : DateBase.deviceList){
                if(device.getDeviceColor().name().equalsIgnoreCase(color)){
                    System.out.println(device.toString());
                }
            }
        waitForEnter();
    }

    public void nameFind(String name) {
        for (Device device : DateBase.deviceList){
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
        for (Device device : DateBase.deviceList){
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
        for(Device device : DateBase.deviceList){
            System.out.println(device);
        }
        waitForEnter();
    }
}
