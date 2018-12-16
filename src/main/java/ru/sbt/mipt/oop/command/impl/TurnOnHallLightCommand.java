package ru.sbt.mipt.oop.command.impl;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.command.api.Command;

public class TurnOnHallLightCommand implements Command {
    final private SmartHome smartHome;

    TurnOnHallLightCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                room.executeAction(objectLight -> {
                    if (objectLight instanceof Light) {
                        ((Light) objectLight).setOn(true);
                    }
                });
            }
        }
    }
}
