package ru.sbt.mipt.oop.events.processor.impl;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class HallDoorEventProcessorTest {
    private SensorEvent event;
    private SmartHome smartHome;

    public void init(String roomName1, String roomName2){
        List<Light> lights = new ArrayList<>();
        lights.add(new Light(true, "1"));
        lights.add(new Light(false, "2"));
        List<Door> doors = new ArrayList<>();
        doors.add(new Door(true, "1"));
        doors.add(new Door(false, "2"));
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(lights, doors, roomName1));
        rooms.add(new Room(lights, doors, roomName2));
        smartHome = mock(SmartHome.class);
        when(smartHome.getRooms()).thenReturn(rooms);
        doNothing().when(smartHome).turnOffLights();
        event = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");
    }

    @Test
    public void processEventTest_notHall() {
        init("kitchen", "bath");
        new HallDoorEventProcessor().processEvent(smartHome, event);
        verify(smartHome, times(0)).turnOffLights();
    }

    @Test
    public void processEventTest_hall() {
        init("kitchen", "hall");
        new HallDoorEventProcessor().processEvent(smartHome, event);
        verify(smartHome, times(1)).turnOffLights();
    }
}
