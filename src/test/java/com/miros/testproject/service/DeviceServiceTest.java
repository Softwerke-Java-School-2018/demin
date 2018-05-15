package com.miros.testproject.service;

import com.miros.testproject.data.DataCreator;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class DeviceServiceTest {

    private DeviceService deviceService;
    private UserService userService;
    private UserActivityService userActivityService;
    private DeviceColor deviceColor = DeviceColor.BLACK;
    private DeviceType deviceType = DeviceType.PHONE;
    private String deviceModel = "Nokia44567";

    @Before
    public void init() {
        deviceService = BaseClassService.getInstance().getDeviceService();
        userService = BaseClassService.getInstance().getUserService();
        userActivityService = BaseClassService.getInstance().getUserActivityService();
        DataCreator dataCreator = new DataCreator();
        dataCreator.dataAdd();
    }

    @Test
    public void save_device_success() throws NullPointerException {
        Device testDevice = Device.builder()
                .setColor(deviceColor)
                .setModel(deviceModel)
                .setType(deviceType)
                .build();

        Optional<Device> result = deviceService.save(testDevice);
        Assert.assertEquals(result.isPresent(), true);
        Assert.assertEquals(result.get().getModel(), testDevice.getModel());
        Assert.assertEquals(result.get().getDeviceColor(), testDevice.getDeviceColor());
        Assert.assertEquals(result.get().getDeviceType(), testDevice.getDeviceType());
        Assert.assertEquals(result.get().getId(), testDevice.getId());
    }

    @Test
    public void save_device_null() throws NullPointerException {
       // Optional<Device> result = deviceService.save(null);
       // Assert.assertEquals(result.isPresent(), false);
    }

    @Test
    public void delete_user_success() throws IndexOutOfBoundsException {
      /*  Device device = deviceService.delete(0);
        Device device1 = deviceService.delete(1);
        Assert.assertEquals(Device.class, device.getClass());
        Assert.assertEquals(Device.class, device1.getClass());
   */
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void delete_user_throws_IndexOutOfBounds() throws IndexOutOfBoundsException {
        deviceService.delete(100);
    }

    @Test
    public void find_user_success() throws IndexOutOfBoundsException {
        Device user = deviceService.find(4);
        Assert.assertNotNull(user);
        Assert.assertEquals(Device.class, user.getClass());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void find_user_by_throws_IndexOutBounds() throws IndexOutOfBoundsException {
        deviceService.find(-2);
    }

    @Test
    public void findAll() {
        Optional<Device> opt = deviceService.findAll().findAny();
        Assert.assertEquals(opt.isPresent(), true);
    }

    @Test
    public void exist() {
        boolean exist = deviceService.exist(3);
        boolean exist2 = deviceService.exist(100);
        Assert.assertEquals(exist, true);
        Assert.assertEquals(exist2, false);
    }

    @After
    public void clear(){
        deviceService.clear();
        userService.clear();
        userActivityService.clear();
        Device.refreshAtomicInteger();
    }
}