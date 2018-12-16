package ru.sbt.mipt.oop.event.provider.api;

import ru.sbt.mipt.oop.SensorEvent;

public interface EventProvider {
    SensorEvent getNextSensorEvent();
}
