package com.miros.testproject.controller.device;

import com.miros.testproject.data.DataCreator;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.enums.DeviceColor;
import com.miros.testproject.data.enums.DeviceType;
import com.miros.testproject.service.DeviceService;
import com.miros.testproject.service.UserActivityService;
import com.miros.testproject.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class DeviceControllerTest {

    @Mock
    private DeviceService deviceService;
    @InjectMocks
    private DeviceController deviceController = new DeviceController();

    private DeviceType enumType;
    private DeviceColor enumColor;
    private String model;

    private UserService userService;
    private UserActivityService userActivityService;

    private String type1;
    private String color1;
    private String model1;

    private Device device;
    private ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());

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
        device = Device.builder()
                .setType(enumType)
                .setColor(enumColor)
                .setModel(model)
                .build();
    }

    @Test
    public void device_Find() {
        deviceService.save(device);
    }

    @Test
    public void create_Device_Controller() {
        DeviceService mockDeviceService = mock(DeviceService.class);
        when(mockDeviceService.save(device)).thenReturn(Optional.of(device));
        when(mockDeviceService.save(null)).thenReturn(Optional.empty());
        deviceController.setDeviceService(mockDeviceService);

        Optional<Device> createDevice = deviceController.create(type1, color1, model1);

        Assert.assertNotNull(device);
        Assert.assertNotNull(createDevice.get());
        Assert.assertEquals(createDevice.get().getDeviceColor(), device.getDeviceColor());
        Assert.assertEquals(createDevice.get().getModel(), device.getModel());
        Assert.assertEquals(createDevice.get().getDeviceType(), device.getDeviceType());
    }

    @Test(expected = NullPointerException.class)
    public void delete_Device_Controller_Throws_NullPointer() {
        DeviceService mockDeviceService = mock(DeviceService.class);
        when(mockDeviceService.delete(device)).thenReturn(Optional.of(device));
        when(mockDeviceService.delete(null)).thenReturn(Optional.empty());
        deviceController.setDeviceService(mockDeviceService);

        Optional<Device> createDevice = deviceController.delete(-2);

        Assert.assertNotNull(device);
        Assert.assertNotNull(createDevice.get());
        Assert.assertEquals(createDevice.get().getDeviceColor(), device.getDeviceColor());
        Assert.assertEquals(createDevice.get().getModel(), device.getModel());
        Assert.assertEquals(createDevice.get().getDeviceType(), device.getDeviceType());
    }

    @After
    public void finish() {
    }
}