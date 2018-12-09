package ru.sbt.mipt.oop.config;

import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.events.processor.api.EventProcessor;
import ru.sbt.mipt.oop.events.processor.impl.*;


public class ProcessorConfig {
    public static Collection<EventProcessor> configureEventProcessors() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();

        eventProcessors.add(new LightEventProcessor());
        eventProcessors.add(new DoorEventProcessor());

        return eventProcessors;
    }
}
