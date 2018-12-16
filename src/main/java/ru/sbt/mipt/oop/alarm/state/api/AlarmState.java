package ru.sbt.mipt.oop.alarm.state.api;

public interface AlarmState {
    void activate(String password);

    void deactivate(String password);

    void setAlarmMode();
}
