package com.miros.controller;

import com.miros.Main;
import com.miros.data.entity.Device;
import com.miros.data.enums.DeviceColor;
import com.miros.data.enums.DeviceType;

/**
 * Контроллер для устройств
 */

public class DeviceConroller extends BaseController {

    private static DeviceConroller deviceConroller = new DeviceConroller();

    public static DeviceConroller getInstance(){
        return deviceConroller;
    }

    public DeviceConroller() {
    }

        public void create(DeviceType deviceType, DeviceColor deviceColor, String model) {
            Main.deviceList.add(new Device(deviceType, deviceColor, model));
            System.out.println("Device created");
            waitForEnter();
        }

        public void delete(Integer id){
            Main.deviceList.remove(id);
            System.out.println("Device deleted");
            waitForEnter();
        }

        public void update(Integer id, String type, String color, String model){
            if(!type.equals("")){
                if(DeviceType.getTypeByString(color).equals(DeviceType.NONE)){
                    baseView.baseMenu();
                } else {
                    Main.deviceList.get(id).setDeviceType(DeviceType.getTypeByString(type));
                }
            }
            if(!color.equals("")){
                if(DeviceColor.getColorByString(color).equals(DeviceColor.NONE)){
                    baseView.baseMenu();
                } else {
                    Main.deviceList.get(id).setDeviceType(DeviceType.getTypeByString(type));
                }
            }
            if(!model.equals("")){
                Main.deviceList.get(id).setModel(model);
            }

            waitForEnter();
        }

}













