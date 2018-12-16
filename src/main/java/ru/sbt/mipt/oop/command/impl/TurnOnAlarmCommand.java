package ru.sbt.mipt.oop.command.impl;

import ru.sbt.mipt.oop.command.api.Command;
import ru.sbt.mipt.oop.SmartHome;

public class TurnOnAlarmCommand implements Command {
    final private SmartHome smartHome;
    final private String password;

    TurnOnAlarmCommand(SmartHome smartHome, String password) {
        this.smartHome = smartHome;
        this.password = password;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().activate(password);
    }
}
