package ru.sbt.mipt.oop.command.impl;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.TestSmartHome;
import ru.sbt.mipt.oop.command.api.Command;

import static org.junit.Assert.assertFalse;

public class CloseHallDoorCommandTest {
    private SmartHome smartHome;
    private Command command;

    @Before
    public void init() {
        smartHome = TestSmartHome.init();
        command = new CloseHallDoorCommand(smartHome);
    }

    @Test
    public void successTest() {
        command.execute();
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door : room.getDoors()) {
                    assertFalse(door.isOpen());
                }
            }
        }
    }
}
