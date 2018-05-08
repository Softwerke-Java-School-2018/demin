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
    private DeviceController deviceController =new DeviceController();
    private DeviceService deviceService = new DeviceService();
    private DeviceType type;
    private DeviceColor color;
    private String model;

    private String type1;
    private String color1;
    private String model1;

    private Device device;

    @Before
    public void init() {
        type = DeviceType.PLAYER;
        color = DeviceColor.BLACK;
        model = "qwer";

        type1 = "PLAYER";
        color1 = "BLACK";
        model1 = "qwer";

        DataCreator dataCreator = new DataCreator();
        dataCreator.dataAdd();
    }

    @Test
    public void deviceMain() {
        device = new Device(type, color, model);
        deviceFindController.findModel(model);
        deviceFindController.findDeviceColor(color.toString());
        deviceFindController.findDeviceType(type.toString());
        deviceService.save(device);
    }

    @Test
    public void testCreate() {
        Optional<Device> device = deviceController.create(type1, color1, model1);
        Assert.assertNotNull(device);
        Assert.assertNotNull(device.get());
        Assert.assertEquals(device.get(), new Device(type, color, model));
    }

    @After
    public void finish() {
    }
}
