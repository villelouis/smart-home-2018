package ru.sbt.mipt.oop.command.impl;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.TestSmartHome;
import ru.sbt.mipt.oop.alarm.state.impl.ActivatedAlarmState;
import ru.sbt.mipt.oop.command.api.Command;

import static org.junit.Assert.assertTrue;

public class TurnOnAlarmCommandTest {
    private SmartHome smartHome;
    private Command command;

    @Before
    public void init() {
        smartHome = TestSmartHome.init();
        command = new TurnOnAlarmCommand(smartHome, "1234");
    }

    @Test
    public void successTest() {
        command.execute();
        assertTrue(smartHome.getAlarm().getAlarmState() instanceof ActivatedAlarmState);
    }
}
