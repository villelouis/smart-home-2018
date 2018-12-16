package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.config.ProcessorConfig;
import ru.sbt.mipt.oop.home.repository.SmartHomeRepository;
import ru.sbt.mipt.oop.home.repository.sources.impl.jsonSmartHomeSource;
import ru.sbt.mipt.oop.home.repository.sources.api.SmartHomeSource;
import ru.sbt.mipt.oop.event.provider.impl.RandomEventProvider;
import ru.sbt.mipt.oop.observer.impl.HomeEventsObserver;
import ru.sbt.mipt.oop.observer.api.Observer;
import java.io.IOException;

public class Application {

    private static SmartHomeSource source = new jsonSmartHomeSource();
    private static SmartHomeRepository repository = new SmartHomeRepository(source);

    public static void main(String... args) throws IOException {

        SmartHome smartHome = repository.loadSmartHome();

        Observer observer = new HomeEventsObserver();
        observer.subscribe(ProcessorConfig.configureEventProcessors());

        EventManager eventManager = new EventManager(observer, new RandomEventProvider());
        eventManager.runEventsCycle(smartHome);


    }

}
