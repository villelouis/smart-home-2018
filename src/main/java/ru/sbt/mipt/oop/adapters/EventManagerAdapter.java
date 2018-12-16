package ru.sbt.mipt.oop.adapters;

import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.event.manager.EventManagerInterface;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.observer.api.Observer;

public class EventManagerAdapter implements EventManagerInterface {
    final private SensorEventsManager sensorEventsManager;
    final private Observer observer;

    public EventManagerAdapter(Observer observer) {
        this.observer = observer;
        sensorEventsManager = new SensorEventsManager();
    }

    @Override
    public void runEventsCycle(SmartHome smartHome) {
        sensorEventsManager.registerEventHandler(ccSensorEvent -> {
            SensorEvent event = new SensorEventAdapter(ccSensorEvent);
            observer.notifySubscribers(smartHome, event);
        });
        sensorEventsManager.start();
    }
}
