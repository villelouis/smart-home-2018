package ru.sbt.mipt.oop.observer.api;

import java.util.Collection;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.processor.api.EventProcessor;

public interface Observer {
    void subscribe(EventProcessor processor);
    void subscribe(Collection<EventProcessor> processors);
    void unsubscribe(EventProcessor processor);
    void notifySubscribers(SmartHome smartHome, SensorEvent event);
}


