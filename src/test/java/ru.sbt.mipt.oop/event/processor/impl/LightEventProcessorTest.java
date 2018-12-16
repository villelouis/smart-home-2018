package ru.sbt.mipt.oop.event.processor.impl;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LightEventProcessorTest {
    private SensorEvent event;
    private SmartHome smartHome;

    @Before
    public void init() {
        smartHome = TestSmartHome.init();
    }


    @Test
    public void processEventTest_switchOnOnLight() {
        event = new SensorEvent(SensorEventType.LIGHT_ON, "1");
        new LightEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            Light light = room.getLightById("1");
            assertTrue(light.isOn());
        }
    }

    @Test
    public void processEventTest_switchOnOffLight() {
        event = new SensorEvent(SensorEventType.LIGHT_ON, "2");
        new LightEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            Light light = room.getLightById("2");
            assertTrue(light.isOn());
        }
    }

    @Test
    public void processEventTest_switchOffOffLight() {
        event = new SensorEvent(SensorEventType.LIGHT_OFF, "2");
        new LightEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            Light light = room.getLightById("2");
            assertFalse(light.isOn());
        }
    }

    @Test
    public void processEventTest_switchOffOnLight() {
        event = new SensorEvent(SensorEventType.LIGHT_OFF, "1");
        new LightEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            Light light = room.getLightById("1");
            assertFalse(light.isOn());
        }
    }
}
