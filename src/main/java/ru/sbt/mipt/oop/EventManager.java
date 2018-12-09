package ru.sbt.mipt.oop;
import ru.sbt.mipt.oop.observer.api.Observer;
import ru.sbt.mipt.oop.events.provider.api.EventProvider;

public class EventManager {
    final private Observer observer;
    final private EventProvider eventProvider;

    EventManager(Observer observer, EventProvider eventProvider) {
        this.observer = observer;
        this.eventProvider = eventProvider;
    }

    public void runEventsCycle(SmartHome smartHome) {
        // начинаем цикл обработки событий
        SensorEvent event = eventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            observer.notifySubscribers(smartHome, event);
            event = eventProvider.getNextSensorEvent();
        }
    }
}
