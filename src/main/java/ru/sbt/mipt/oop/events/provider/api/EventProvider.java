package ru.sbt.mipt.oop.events.provider.api;

import ru.sbt.mipt.oop.SensorEvent;

public interface EventProvider {
    SensorEvent getNextSensorEvent();
}
