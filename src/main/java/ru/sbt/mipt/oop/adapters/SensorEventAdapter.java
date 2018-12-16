package ru.sbt.mipt.oop.adapters;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;

public class SensorEventAdapter extends SensorEvent {

    public SensorEventAdapter(CCSensorEvent ccSensorEvent) {
        super(convertType(ccSensorEvent.getEventType()), ccSensorEvent.getObjectId());
    }

    private static SensorEventType convertType(String ccType) {
        switch (ccType) {
            case ("LightIsOn"):
                return SensorEventType.LIGHT_ON;
            case ("LightIsOff"):
                return SensorEventType.LIGHT_OFF;
            case ("DoorIsOpen"):
                return SensorEventType.DOOR_OPEN;
            case ("DoorIsClosed"):
                return SensorEventType.DOOR_CLOSED;
            default:
                return null;
        }
    }
}
