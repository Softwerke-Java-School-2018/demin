package com.miros.controller;

import com.miros.Main;
import com.miros.data.entity.Device;

/**
 * Контроллер для поиска устройств
 */
public class DeviceFindController extends BaseController {
   public void deviceIdFind(Integer id){
        System.out.println(Main.deviceList.get(id));
        waitForEnter();
    }

    /**
     * Поиск по цвету устройства
     * @param color
     */
    public void deviceColorFind(String color){
            for (Device device : Main.deviceList){
                if(device.getDeviceColor().name().equalsIgnoreCase(color)){
                    System.out.println(device.toString());
                }
            }
        waitForEnter();
    }

    /**
     * Поиск по типу устройства
     * @param type
     */
    public void deviceTypeFind(String type){
        for (Device device : Main.deviceList){
            if(device.getDeviceType().name().equalsIgnoreCase(type)){
                System.out.println(device.toString());
            }
        }
        waitForEnter();
    }

    /**
     * Вывод всех устройств
     */
    public void showAllDevices(){
        for(Device device : Main.deviceList){
            System.out.println(device);
        }
        waitForEnter();
    }
}
