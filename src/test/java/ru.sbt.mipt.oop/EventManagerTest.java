package ru.sbt.mipt.oop;

import org.junit.Before;
import org.junit.Test;

import ru.sbt.mipt.oop.observer.api.Observer;
import ru.sbt.mipt.oop.observer.impl.HomeEventsObserver;
import ru.sbt.mipt.oop.event.provider.api.EventProvider;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class EventManagerTest {
    private Observer observer;
    private EventProvider eventProvider;
    private SmartHome smartHome;
    private SensorEvent sensorEvent;


    @Before
    public void init() {
        sensorEvent = mock(SensorEvent.class);
        when(sensorEvent.toString()).thenReturn("mockEvent");

        observer = mock(HomeEventsObserver.class);
        doNothing().when(observer).notifySubscribers(smartHome, mock(SensorEvent.class));

        eventProvider = mock(EventProvider.class);
        when(eventProvider.getNextSensorEvent()).thenReturn(sensorEvent).thenReturn(null);

        smartHome = mock(SmartHome.class);
    }

    @Test
    public void runEventsCycleTest() {
        new EventManager(observer, eventProvider).runEventsCycle(smartHome);
        verify(observer, times(1)).notifySubscribers(any(), any());
    }
}
