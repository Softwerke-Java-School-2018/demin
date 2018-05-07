import com.miros.testproject.controller.device.DeviceController;
import com.miros.testproject.controller.device.DeviceFindController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.service.DeviceService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeviceTest {
    private DeviceFindController deviceFindController = new DeviceFindController();
    private DeviceService deviceService = new DeviceService();
    private DeviceType type;
    private DeviceColor color;
    private String model;

    private DeviceType errType;
    private DeviceColor errColor;
    private String errModel;

    private Device device;

    @Before
    public void init() {
        type = DeviceType.LAPTOP;
        color = DeviceColor.BLACK;
        model = "qwert";

        errType = DeviceType.NONE;
        errColor = DeviceColor.NONE;
        errModel = "qwer";
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
    public void deviceColorFind() {
        deviceService.save(device);
    }

    @After
    public void finish() {
    }
}
