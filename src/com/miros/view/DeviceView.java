package com.miros.view;

import com.miros.controller.DeviceConroller;
import com.miros.data.enums.DeviceColor;
import com.miros.data.enums.DeviceType;

import java.util.Scanner;

/**
 * View для управления устройствами
 */
public class DeviceView {

    public void deviceMenu() {
            System.out.println("Enter the command number:\n" +
                    "1 - device create\n" +
                    "2 - device remove\n" +
                    "3 - device update\n");

            String command = readLine();
            switch (command) {
                case "1":
                    createDevice();
                case "2":
                    deleteDevice();
                case "3":
                    updateDevice();

        }
    }
    public String readLine () {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }
        /**
         * Создание устройства, вызов контроллера
         */
        private void createDevice () {
            System.out.println("Enter type");
            String type = readLine();

            DeviceType deviceType = DeviceType.getTypeByString(type);

            System.out.println("Enter color");
            String color = readLine();

            DeviceColor deviceColor = DeviceColor.getColorByString(color);

            System.out.println("Enter model");
            String model = readLine().toUpperCase();

            new DeviceConroller().create(deviceType, deviceColor, model);
        }

        /**
         * Удаление устройства, вызов контроллера
         */
        private void deleteDevice () {
            System.out.println("Enter Id");
            Integer id = Integer.parseInt(readLine());
            new DeviceConroller().delete(id);
        }

        /**
         * Обновление устройства, вызов контроллера
         */
        private void updateDevice () {
            System.out.println("Enter id element to update");
            Integer id = Integer.parseInt(readLine());
            System.out.println("Enter a Type for the change or leave it empty to leave as is");
            String type = readLine();
            System.out.println("Enter a Color for the change or leave it empty to leave as is");
            String color = readLine();
            System.out.println("Enter a Model for the change or leave it empty to leave as is");
            String model = readLine();

            new DeviceConroller().update(id, type, color, model);

        }

}
