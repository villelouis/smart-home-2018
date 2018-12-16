package ru.sbt.mipt.oop.observer.impl;

import ru.sbt.mipt.oop.event.processor.api.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HomeEventsObserverTest {
    HomeEventsObserver observer;

    @Before
    public void init() {
        observer = new HomeEventsObserver();
    }

    private int getLengthArray(HomeEventsObserver observer) throws NoSuchFieldException, IllegalAccessException {
        Field subscribers = HomeEventsObserver.class.getDeclaredField("subscribers");
        subscribers.setAccessible(true);
        ArrayList arrayList = (ArrayList<EventProcessor>) subscribers.get(observer);
        return arrayList.size();
    }

    @Test
    public void subscribeTest() throws NoSuchFieldException, IllegalAccessException {
        EventProcessor processor = mock(EventProcessor.class);
        observer.subscribe(processor);
        assertEquals(1, getLengthArray(observer));
    }

    @Test
    public void subscribeTestSeveral() throws NoSuchFieldException, IllegalAccessException {
        EventProcessor processor = mock(EventProcessor.class);
        ArrayList<EventProcessor> processors = new ArrayList<>();
        processors.add(processor);
        processors.add(processor);
        observer.subscribe(processors);
        assertEquals(2, getLengthArray(observer));
    }

    @Test
    public void unsubscribeTest() throws NoSuchFieldException, IllegalAccessException {
        EventProcessor processor = mock(EventProcessor.class);
        observer.subscribe(processor);
        observer.unsubscribe(processor);
        assertEquals(0, getLengthArray(observer));
    }

    @Test
    public void notifySubscribersTest() {
        SmartHome smartHome = mock(SmartHome.class);
        SensorEvent event = mock(SensorEvent.class);
        EventProcessor processor = mock(EventProcessor.class);
        doNothing().when(processor).processEvent(smartHome, event);
        ArrayList<EventProcessor> processors = new ArrayList<>();
        processors.add(processor);
        processors.add(processor);
        observer.subscribe(processors);
        observer.notifySubscribers(smartHome, event);
        verify(processor, times(2)).processEvent(any(), any());
    }
}
