package ru.sbt.mipt.oop.event.processor.api;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent sensorEvent);
}
