package ru.sbt.mipt.oop.command.impl;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.TestSmartHome;
import ru.sbt.mipt.oop.command.api.Command;

import static org.junit.Assert.assertTrue;

public class TurnOnHallLightCommandTest {
    private SmartHome smartHome;
    private Command command;

    @Before
    public void init() {
        smartHome = TestSmartHome.init();
        command = new TurnOnHallLightCommand(smartHome);
    }

    @Test
    public void successTest() {
        command.execute();
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Light light : room.getLights()) {
                    assertTrue(light.isOn());
                }
            }
        }
    }
}
