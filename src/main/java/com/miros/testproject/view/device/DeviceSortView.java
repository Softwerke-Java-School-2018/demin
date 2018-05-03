package com.miros.testproject.view.device;

import com.miros.testproject.controller.device.DeviceSortController;
import com.miros.testproject.view.BaseClassView;

import lombok.Data;

@Data
public class DeviceSortView extends BaseClassView {
    private DeviceSortController deviceSortController = new DeviceSortController();
    private final String DEVICE_SORT_VIEW = "Choose which parameter use for sort\n" +
            "1 - Model\n" +
            "2 - Type\n" +
            "3 - Color\n";

    public void deviceSort() {
        utils.printLine(DEVICE_SORT_VIEW);
        String num = utils.readLine();
        switch (num) {
            case "1":
                deviceSortController.sortByModel();
            case "2":
                deviceSortController.sortByType();
            case "3":
                deviceSortController.sortByColor();
            default:
                utils.printLine("It's Wrong");
                waitForEnter();
        }
    }
}
