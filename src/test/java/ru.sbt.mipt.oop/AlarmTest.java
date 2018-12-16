package ru.sbt.mipt.oop;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.alarm.Alarm;
import static org.junit.Assert.assertTrue;
import ru.sbt.mipt.oop.alarm.state.impl.DeactivatedAlarmState;
import ru.sbt.mipt.oop.alarm.state.impl.ActivatedAlarmState;
import ru.sbt.mipt.oop.alarm.state.impl.AlarmModeAlarmState;

public class AlarmTest {
    private Alarm alarm;

    @Before
    public void init() {
        alarm = new Alarm();
    }


    @Test
    public void activateDeactivatedAlarm() {
        assertTrue(alarm.getAlarmState() instanceof DeactivatedAlarmState);
        alarm.activate("qwe");
        assertTrue(alarm.getAlarmState() instanceof ActivatedAlarmState);
    }

    @Test
    public void deactivateActivatedAlarm() {
        alarm.activate("qwe");
        alarm.deactivate("qwe");
        assertTrue(alarm.getAlarmState() instanceof DeactivatedAlarmState);
    }

    @Test
    public void WrongPassword() {
        alarm.activate("qwe");
        alarm.deactivate("ewq");
        assertTrue(alarm.getAlarmState() instanceof AlarmModeAlarmState);
    }

    @Test
    public void deactivateAlarmedAlarm() {
        alarm.activate("qwe");
        alarm.deactivate("ewq");
        assertTrue(alarm.getAlarmState() instanceof AlarmModeAlarmState);
        alarm.deactivate("qwe");
        assertTrue(alarm.getAlarmState() instanceof DeactivatedAlarmState);
    }
}
