package ru.sbt.mipt.oop.command.impl;

import ru.sbt.mipt.oop.command.api.Command;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class TurnOffAllLightCommand implements Command {
    final private SmartHome smartHome;

    TurnOffAllLightCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                ((Light) object).setOn(false);
            }
        });
    }
}
