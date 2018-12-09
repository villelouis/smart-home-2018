package ru.sbt.mipt.oop.events.provider;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;

public class RandomEventProvider{

    public static SensorEvent getNextSensorEvent() {
            if (Math.random() < 0.05) return null; // null means end of event stream
            SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
            String objectId = "" + ((int) (10 * Math.random()));
            return new SensorEvent(sensorEventType, objectId);
    }
}
