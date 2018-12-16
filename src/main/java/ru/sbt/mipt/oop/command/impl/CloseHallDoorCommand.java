package ru.sbt.mipt.oop.command.impl;

import ru.sbt.mipt.oop.command.api.Command;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class CloseHallDoorCommand implements Command {
    final private SmartHome smartHome;

    CloseHallDoorCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                room.executeAction(objectDoor -> {
                    if (objectDoor instanceof Door) {
                        ((Door) objectDoor).setOpen(false);
                    }
                });
            }
        }
    }
}
