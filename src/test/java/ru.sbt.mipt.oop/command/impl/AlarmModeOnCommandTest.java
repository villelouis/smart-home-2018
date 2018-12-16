package ru.sbt.mipt.oop.command.impl;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.TestSmartHome;
import ru.sbt.mipt.oop.alarm.state.impl.AlarmModeAlarmState;
import ru.sbt.mipt.oop.command.api.Command;


import static org.junit.Assert.assertTrue;

public class AlarmModeOnCommandTest {
    private SmartHome smartHome;
    private Command command;

    @Before
    public void init() {
        smartHome = TestSmartHome.init();
        command = new AlarmModeOnCommand(smartHome);
    }

    @Test
    public void successTest() {
        command.execute();
        assertTrue(smartHome.getAlarm().getAlarmState() instanceof AlarmModeAlarmState);
    }
}
