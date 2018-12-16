package ru.sbt.mipt.oop.alarm.state.impl;

import ru.sbt.mipt.oop.alarm.state.api.AlarmState;
import ru.sbt.mipt.oop.alarm.Alarm;

public class ActivatedAlarmState implements AlarmState {
    private Alarm alarm;
    private String password;

    ActivatedAlarmState(Alarm alarm, String password) {
        this.alarm = alarm;
        this.password = password;
    }

    @Override
    public void activate(String password) {

    }

    @Override
    public void deactivate(String password) {
        if (this.password.equals(password)) {
            alarm.changeAlarmState(new DeactivatedAlarmState(alarm));
        } else {
            alarm.changeAlarmState(new AlarmModeAlarmState(alarm, this.password));
            alarm.setAlarmMode();
        }
    }

    @Override
    public void setAlarmMode() {
        alarm.changeAlarmState(new AlarmModeAlarmState(alarm, password));
        alarm.setAlarmMode();
    }
}
