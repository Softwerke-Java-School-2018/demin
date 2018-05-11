package com.miros.testproject.view.device;

import com.miros.testproject.controller.ControllersFabric;
import com.miros.testproject.controller.device.DeviceFindController;
import com.miros.testproject.view.BaseView;
import lombok.Data;

/**
 *  This class creates a menu to search
 *  for devices and redirects it to the controller
 */
@Data
public class DeviceFindView extends BaseView {
    private DeviceFindController deviceFindController = (DeviceFindController) ControllersFabric.getController(DeviceFindController.class).get();
    private final String DEVICE_FIND_VIEW = "Choose which parameter will be searched\n" +
            "1 - id\n" +
            "2 - Type\n" +
            "3 - Color\n" +
            "4 - Model\n" +
            "5 - Show all devices";
    public void deviceFinder() {
        utils.printLine(DEVICE_FIND_VIEW);
        String num = utils.readLine();
        switch (num) {
            case "1":
                utils.printLine("Enter id");
                Integer id = Integer.parseInt(utils.readLine());
                deviceFindController.findId(id);
            case "2":
                utils.printLine("Enter type");
                String type = utils.readLine();
                deviceFindController.findDeviceType(type);
            case "3":
                utils.printLine("Enter color");
                String color = utils.readLine();
                deviceFindController.findColor(color);
            case "4":
                utils.printLine("Enter model");
                String model = utils.readLine();
                deviceFindController.findModel(model);
            case "5":
                deviceFindController.showAll();
            default:
                utils.printLine("It's Wrong");
                waitForEnter();
        }
    }
}
