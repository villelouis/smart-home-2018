package ru.sbt.mipt.oop.observer.impl;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.processor.api.EventProcessor;
import ru.sbt.mipt.oop.observer.api.Observer;

import java.util.ArrayList;
import java.util.Collection;

public class HomeEventsObserver implements Observer {

    private ArrayList<EventProcessor> subscribers = new ArrayList<>();

    @Override
    public void subscribe(EventProcessor processor) {
        subscribers.add(processor);
    }

    @Override
    public void subscribe(Collection<EventProcessor> processors) {
        subscribers.addAll(processors);
    }

    @Override
    public void unsubscribe(EventProcessor processor) {
        subscribers.remove(processor);
    }

    @Override
    public void notifySubscribers(SmartHome smartHome, SensorEvent event) {
        for (EventProcessor subscriber : subscribers) {
            subscriber.processEvent(smartHome, event);
        }
    }
}
