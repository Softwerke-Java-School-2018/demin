package com.miros.testproject.controller.device;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;


public class DeviceController extends BaseController {

    private static DeviceController deviceConroller = new DeviceController();

    public static DeviceController getInstance(){
        return deviceConroller;
    }

    public DeviceController() {
    }
        public void create(DeviceType deviceType, DeviceColor deviceColor, String model) {
            DeviceDAO.deviceDAO.add(new Device(deviceType, deviceColor, model));
            Utils.printLine("Device created");
            waitForEnter();
        }

        public void delete(Integer id){
            DeviceDAO.deviceDAO.remove(id);
            Utils.printLine("Device deleted");
            waitForEnter();
        }

        public void update(Integer id, String type, String color, String model){
            if(!type.equals("")){
                if(DeviceType.getTypeByString(color).equals(DeviceType.NONE)){
                    DeviceController.getInstance().getBaseView().baseMenu();
                } else {
                    DeviceDAO.deviceDAO.get(id).setDeviceType(DeviceType.getTypeByString(type));
                }
            }
            if(!color.equals("")){
                if(DeviceColor.getColorByString(color).equals(DeviceColor.NONE)){
                    DeviceController.getInstance().getBaseView().baseMenu();
                } else {
                    DeviceDAO.deviceDAO.get(id).setDeviceType(DeviceType.getTypeByString(type));
                }
            }
            if(!model.equals("")){
                DeviceDAO.deviceDAO.get(id).setModel(model);
            }
            waitForEnter();
        }

}












