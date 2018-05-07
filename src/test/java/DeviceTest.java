import com.miros.testproject.controller.device.DeviceController;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.service.DeviceService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeviceTest {

    private DeviceController deviceController = new DeviceController();
    private DeviceService deviceService = new DeviceService();
    static DeviceType type;
    static DeviceColor color;
    static String model;

    @Before
    public void init() {
        type = DeviceType.LAPTOP;
        color = DeviceColor.BLACK;
        model = "qwert";
    }

    @Test
    public void deviceCreate() {
        Device device = Device.builder()
                .deviceColor(color)
                .deviceType(type)
                .model(model)
                .build();
        deviceService.save(device);
    }

    @After
    public void finish() {

    }
}
