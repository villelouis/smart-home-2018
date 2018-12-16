package ru.sbt.mipt.oop.command.impl;

import ru.sbt.mipt.oop.command.api.Command;
import ru.sbt.mipt.oop.SmartHome;

public class AlarmModeOnCommand implements Command {
    final private SmartHome smartHome;

    AlarmModeOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().setAlarmMode();
    }
}
