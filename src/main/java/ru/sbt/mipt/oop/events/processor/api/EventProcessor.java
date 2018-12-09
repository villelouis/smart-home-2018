package ru.sbt.mipt.oop.events.processor.api;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public interface EventProcessor {
    public void proccessEvent(SmartHome smartHome, SensorEvent sensorEvent);
}
