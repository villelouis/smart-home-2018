package ru.sbt.mipt.oop.events.processor.impl;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.events.processor.api.EventProcessor;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() != DOOR_CLOSED) return;
        // событие от двери
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                room.executeAction(objectDoor -> {
                    if (objectDoor instanceof Door) {
                        if (((Door) objectDoor).getId().equals(event.getObjectId())) smartHome.turnOffLights();
                    }
                });
            }

        }
    }
}
