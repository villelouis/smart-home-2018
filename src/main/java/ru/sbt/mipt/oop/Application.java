package ru.sbt.mipt.oop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.sbt.mipt.oop.config.GeneralConfiguration;
import ru.sbt.mipt.oop.event.manager.EventManagerInterface;
import ru.sbt.mipt.oop.home.repository.SmartHomeRepository;
import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(GeneralConfiguration.class);
        EventManagerInterface eventManagerInterface = context.getBean(EventManagerInterface.class);
        SmartHomeRepository repository = context.getBean(SmartHomeRepository.class);
        eventManagerInterface.runEventsCycle(repository.loadSmartHome());
    }

}
