package ru.sbt.mipt.oop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.event.manager.EventManagerInterface;
import ru.sbt.mipt.oop.event.processor.api.EventProcessor;
import ru.sbt.mipt.oop.event.processor.impl.DoorEventProcessor;
import ru.sbt.mipt.oop.event.processor.impl.HallDoorEventProcessor;
import ru.sbt.mipt.oop.event.processor.impl.LightEventProcessor;
import ru.sbt.mipt.oop.home.repository.SmartHomeRepository;
import ru.sbt.mipt.oop.observer.api.Observer;
import ru.sbt.mipt.oop.adapters.EventManagerAdapter;
import ru.sbt.mipt.oop.observer.impl.HomeEventsObserver;
import ru.sbt.mipt.oop.home.repository.sources.impl.jsonSmartHomeSource;
import ru.sbt.mipt.oop.home.repository.sources.api.SmartHomeSource;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class GeneralConfiguration {

    GeneralConfiguration() {}

    @Bean
    public EventManagerInterface eventManager() {
        Observer observer = configureSimpleObserver();
        return new EventManagerAdapter(observer);
    }

    @Bean
    public SmartHomeRepository smartHomeRepository() {
        SmartHomeSource source = new jsonSmartHomeSource();
        return new SmartHomeRepository(source);
    }

    private static Observer configureSimpleObserver() {
        Observer observer = new HomeEventsObserver();
        observer.subscribe(configureEventProcessors());
        return observer;
    }

    private static Collection<EventProcessor> configureEventProcessors() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new LightEventProcessor());
        eventProcessors.add(new DoorEventProcessor());
        eventProcessors.add(new HallDoorEventProcessor());
        return eventProcessors;
    }
}
