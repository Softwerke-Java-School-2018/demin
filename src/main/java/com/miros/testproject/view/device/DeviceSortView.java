package com.miros.testproject.view.device;

;
import com.miros.testproject.controller.ControllersFabric;
import com.miros.testproject.controller.device.DeviceSortController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.view.BaseView;
import com.miros.testproject.view.SortView;
import lombok.Data;
import java.util.List;
import java.util.stream.Stream;


/**
 *  This class creates a menu to sort
 *  for devices and redirects it to Sort controller
 */
@Data
public class DeviceSortView extends BaseView implements SortView {
    private DeviceSortController deviceSortController =  (DeviceSortController) ControllersFabric.getController(DeviceSortController.class).get();
    private final String DEVICE_SORT_VIEW = "Choose which parameter use for sort\n" +
            "1 - Model\n" +
            "2 - Type\n" +
            "3 - Color\n";

    /**
     *
     * @param deviceList this contains devices to sort
     */
    public void sort(List deviceList) {
        utils.printLine(DEVICE_SORT_VIEW);
        String num = utils.readLine();
        switch (num) {
            case "1":
                deviceSortController.sortModel(deviceList);
                return;
            case "2":
                deviceSortController.sortType(deviceList);
                return;
            case "3":
                deviceSortController.sortColor(deviceList);
                return;
            default:
               return;
        }
    }
}
