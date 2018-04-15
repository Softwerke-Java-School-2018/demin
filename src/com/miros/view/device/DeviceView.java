package com.miros.view.device;

import com.miros.Utils;
import com.miros.controller.device.DeviceController;
import com.miros.data.enums.DeviceColor;
import com.miros.data.enums.DeviceType;

/**
 * View для управления устройствами
 */
public class DeviceView {
    private static final String DEVICE_VIEW="Enter the command number:\n" +
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
    /**
     * Создание устройства, вызов контроллера
     */
    private void createDevice() {
        Utils.printLine("Enter type");
        String type = Utils.readLine();

        DeviceType deviceType = DeviceType.getTypeByString(type);

        Utils.printLine("Enter color");
        String color = Utils.readLine();

        DeviceColor deviceColor = DeviceColor.getColorByString(color);

        Utils.printLine("Enter model");
        String model = Utils.readLine().toUpperCase();

        DeviceController.getInstance().create(deviceType, deviceColor, model);
    }
    /**
     * Удаление устройства, вызов контроллера
     */
    private void deleteDevice() {
        Utils.printLine("Enter Id");
        Integer id = Integer.parseInt(Utils.readLine());
        DeviceController.getInstance().delete(id);
    }
    /**
     * Обновление устройства, вызов контроллера
     */
    private void updateDevice() {
        Utils.printLine("Enter id element to update");
        Integer id = Integer.parseInt(Utils.readLine());
        Utils.printLine("Enter a Type for the change or leave it empty to leave as is");
        String type = Utils.readLine();
        Utils.printLine("Enter a Color for the change or leave it empty to leave as is");
        String color = Utils.readLine();
        Utils.printLine("Enter a Model for the change or leave it empty to leave as is");
        String model = Utils.readLine();

        DeviceController.getInstance().update(id, type, color, model);
    }
}
