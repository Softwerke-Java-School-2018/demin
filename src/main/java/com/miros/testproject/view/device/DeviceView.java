package com.miros.testproject.view.device;

import com.miros.testproject.controller.ControllersFabric;
import com.miros.testproject.controller.device.DeviceController;
import com.miros.testproject.view.BaseView;

/**
 * This class creates a menu for Create, Delete, Update
 *  some device and redirect on device Controller
 */
public class DeviceView extends BaseView {
    private DeviceController deviceController = (DeviceController) ControllersFabric.getController(DeviceController.class).get();
    private static final String DEVICE_VIEW = "Enter the command number:\n" +
            "1 - device create\n" +
            "2 - device remove\n" +
            "3 - device update\n";

    public void deviceMenu() {
        utils.printLine(DEVICE_VIEW);
        String command = utils.readLine();
        switch (command) {
            case "1":
                createDevice();
            case "2":
                deleteDevice();
            case "3":
                updateDevice();
            default:
                utils.printLine("It's Wrong");
                waitForEnter();
        }
    }

    private void createDevice() {
        utils.printLine("Enter type");
        String deviceType = utils.readLine();
        utils.printLine("Enter color");
        String deviceColor = utils.readLine();
        utils.printLine("Enter model");
        String model = utils.readLine().toUpperCase();
        deviceController.create(deviceType, deviceColor, model);
    }

    private void deleteDevice() {
        utils.printLine("Enter Id");
        Integer id = Integer.parseInt(utils.readLine());
        deviceController.delete(id);
    }

    private void updateDevice() {
        utils.printLine("Enter id element to update");
        Integer id = Integer.parseInt(utils.readLine());
        utils.printLine("Enter a Type for the change or leave it empty to leave as is");
        String type = utils.readLine();
        utils.printLine("Enter a Color for the change or leave it empty to leave as is");
        String color = utils.readLine();
        utils.printLine("Enter a Model for the change or leave it empty to leave as is");
        String model = utils.readLine();
        deviceController.update(id, type, color, model);
    }
}
