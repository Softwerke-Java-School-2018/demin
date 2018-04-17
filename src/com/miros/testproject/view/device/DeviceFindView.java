package com.miros.testproject.view.device;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.device.DeviceFindController;

public class DeviceFindView {

    private DeviceFindController deviceFindController = DeviceFindController.getInstance();

    private final String DEVICE_FIND_VIEW = "Choose which parameter will be searched\n" +
            "1 - id\n" +
            "2 - Type\n" +
            "3 - Color\n" +
            "4 - Show all devices";

    public void deviceFinder() {
        Utils.printLine(DEVICE_FIND_VIEW);
        String num = Utils.readLine();
        switch (num) {
            case "1":
                Utils.printLine("Enter id");
                Integer id = Integer.parseInt(Utils.readLine());
                deviceFindController.idFind(id);
            case "2":
                Utils.printLine("Enter type");
                String type = Utils.readLine();
                deviceFindController.deviceTypeFind(type);
            case "3":
                Utils.printLine("Enter color");
                String color = Utils.readLine();
                deviceFindController.deviceColorFind(color);
            case "4":
                deviceFindController.showAll();
        }
    }
}
