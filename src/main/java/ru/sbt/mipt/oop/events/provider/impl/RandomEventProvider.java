package ru.sbt.mipt.oop.events.provider.impl;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.events.provider.api.EventProvider;

public class RandomEventProvider implements EventProvider {

    public SensorEvent getNextSensorEvent() {
            if (Math.random() < 0.05) return null; // null means end of event stream
            SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
            String objectId = "" + ((int) (10 * Math.random()));
            return new SensorEvent(sensorEventType, objectId);
    }
}
