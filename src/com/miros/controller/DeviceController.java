package com.miros.controller;

import com.miros.Main;
import com.miros.data.DateBase;
import com.miros.data.entity.Device;
import com.miros.data.enums.DeviceColor;
import com.miros.data.enums.DeviceType;

/**
 * Контроллер для устройств
 */

public class DeviceController extends BaseController {

    private static DeviceController deviceConroller = new DeviceController();

    public static DeviceController getInstance(){
        return deviceConroller;
    }

    public DeviceController() {
    }

        public void create(DeviceType deviceType, DeviceColor deviceColor, String model) {
            DateBase.deviceList.add(new Device(deviceType, deviceColor, model));
            System.out.println("Device created");
            waitForEnter();
        }

        public void delete(Integer id){
            DateBase.deviceList.remove(id);
            System.out.println("Device deleted");
            waitForEnter();
        }

        public void update(Integer id, String type, String color, String model){
            if(!type.equals("")){
                if(DeviceType.getTypeByString(color).equals(DeviceType.NONE)){
                    DeviceController.getInstance().getBaseView().baseMenu();
                } else {
                    DateBase.deviceList.get(id).setDeviceType(DeviceType.getTypeByString(type));
                }
            }
            if(!color.equals("")){
                if(DeviceColor.getColorByString(color).equals(DeviceColor.NONE)){
                    DeviceController.getInstance().getBaseView().baseMenu();
                } else {
                    DateBase.deviceList.get(id).setDeviceType(DeviceType.getTypeByString(type));
                }
            }
            if(!model.equals("")){
                DateBase.deviceList.get(id).setModel(model);
            }

            waitForEnter();
        }

}













