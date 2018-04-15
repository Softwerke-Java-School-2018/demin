package com.miros.view.device;

import com.miros.Utils;
import com.miros.controller.device.DeviceFindController;

public class DeviceFindView {
    private final String DEVICE_FIND_VIEW="Choose which parameter will be searched\n" +
            "1 - id\n" +
            "2 - Type\n" +
            "3 - Color\n" +
            "4 - Show all devices";
    /**
     * Модуль поиска устройств
     */
    public void deviceFinder(){
        Utils.printLine(DEVICE_FIND_VIEW);
        String num = Utils.readLine();
        switch (num) {
            case "1":
                Utils.printLine("Enter id");
                Integer id = Integer.parseInt(Utils.readLine());
                DeviceFindController.getInstance().idFind(id);
            case "2":
                Utils.printLine("Enter type");
                String type = Utils.readLine();
                DeviceFindController.getInstance().deviceTypeFind(type);
            case "3":
                Utils.printLine("Enter color");
                String color = Utils.readLine();
                DeviceFindController.getInstance().deviceColorFind(color);
            case "4":
                DeviceFindController.getInstance().showAll();
        }
    }
}
