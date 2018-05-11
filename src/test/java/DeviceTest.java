import com.miros.testproject.controller.device.DeviceController;
import com.miros.testproject.controller.device.DeviceFindController;
import com.miros.testproject.data.DataCreator;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.service.DeviceService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class DeviceTest {
    private DeviceFindController deviceFindController = new DeviceFindController();
    private DeviceController deviceController = new DeviceController();
    private DeviceService deviceService = new DeviceService();
    private DeviceType enumType;
    private DeviceColor enumColor;
    private String model;

    private String type1;
    private String color1;
    private String model1;

    private Device device;

    @Before
    public void init() {
        enumType = DeviceType.PLAYER;
        enumColor = DeviceColor.BLACK;
        model = "qwer";

        type1 = "PLAYER";
        color1 = "BLACK";
        model1 = "qwer";

        DataCreator dataCreator = new DataCreator();
        dataCreator.dataAdd();
    }

    @Test
    public void device_Find() {
        device = new Device(enumType, enumColor, model);
        deviceFindController.findModel(model);
        deviceFindController.findColor(enumColor.toString());
        deviceFindController.findDeviceType(enumType.toString());
        deviceService.save(device);
    }

    @Test
    public void create_Device_Controller() {
        Optional<Device> device = deviceController.create(type1, color1, model1);
        Assert.assertNotNull(device);
        Assert.assertNotNull(device.get());
        Assert.assertEquals(device.get(), new Device(enumType, enumColor, model));
    }

    @After
    public void finish() {
    }
}
