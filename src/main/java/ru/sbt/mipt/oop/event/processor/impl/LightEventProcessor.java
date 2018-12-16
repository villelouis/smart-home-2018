package ru.sbt.mipt.oop.event.processor.impl;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.processor.api.EventProcessor;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor{

    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        if (!isLightEvent(sensorEvent)) return;
        // событие от источника света
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                if (light.getId().equals(sensorEvent.getObjectId())) {
                    if (sensorEvent.getType() == LIGHT_ON) {
                        changeLightState(light, true, " was turned on.");
                    } else {
                        changeLightState(light, false, " was turned off.");
                    }
                }
            }
        });
    }

    private void changeLightState(Light light, boolean state, String text) {
        light.setOn(state);
        System.out.println("Light " + light.getId() + " " + text);
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
}
