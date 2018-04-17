package com.miros.testproject.view.device;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.device.DeviceController;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;

/**
 * View для управления устройствами
 */
public class DeviceView {

    private DeviceController deviceController = DeviceController.getInstance();

    private static final String DEVICE_VIEW = "Enter the command number:\n" +
            "1 - device create\n" +
            "2 - device remove\n" +
            "3 - device update\n";

    public void deviceMenu() {
        Utils.printLine(DEVICE_VIEW);
        String command = Utils.readLine();
        switch (command) {
            case "1":
                createDevice();
            case "2":
                deleteDevice();
            case "3":
                updateDevice();
        }
    }

    private void createDevice() {
        Utils.printLine("Enter type");
        String deviceType = Utils.readLine();

        Utils.printLine("Enter color");
        String deviceColor = Utils.readLine();

        Utils.printLine("Enter model");
        String model = Utils.readLine().toUpperCase();

        deviceController.create(deviceType, deviceColor, model);
    }

    private void deleteDevice() {
        Utils.printLine("Enter Id");
        Integer id = Integer.parseInt(Utils.readLine());
        deviceController.delete(id);
    }

    private void updateDevice() {
        Utils.printLine("Enter id element to update");
        Integer id = Integer.parseInt(Utils.readLine());
        Utils.printLine("Enter a Type for the change or leave it empty to leave as is");
        String type = Utils.readLine();
        Utils.printLine("Enter a Color for the change or leave it empty to leave as is");
        String color = Utils.readLine();
        Utils.printLine("Enter a Model for the change or leave it empty to leave as is");
        String model = Utils.readLine();
        deviceController.update(id, type, color, model);
    }
}
