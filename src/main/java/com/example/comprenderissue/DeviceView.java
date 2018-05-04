package com.example.comprenderissue;

import java.util.Arrays;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

import static com.example.comprenderissue.DeviceView.DEVICES;
import static com.example.comprenderissue.UsersView.USERS;

@Route(value = DEVICES, layout = MainView.class)
public class DeviceView extends Grid<Device> {

    public static final String DEVICES = "devices";

    public DeviceView() {

        setItems(Arrays.asList(new Device ("Device 1", true),
                new Device("Device 2", false), new Device("Device 3", true)));


        addColumn(Device::getId).setHeader("Device ID");
        addColumn(new ComponentRenderer<>(f -> new Checkbox(f.getEnabled())))
                .setHeader("Enabled");


    }
}
