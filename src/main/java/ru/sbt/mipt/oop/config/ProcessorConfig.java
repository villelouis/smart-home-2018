package ru.sbt.mipt.oop.config;

import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.event.processor.api.EventProcessor;
import ru.sbt.mipt.oop.event.processor.impl.*;


public class ProcessorConfig {
    public static Collection<EventProcessor> configureEventProcessors() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();

        eventProcessors.add(new LightEventProcessor());
        eventProcessors.add(new DoorEventProcessor());

        return eventProcessors;
    }
}
