package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.events.processor.impl.DoorEventProcessor;
import ru.sbt.mipt.oop.events.processor.impl.LightEventProcessor;
import ru.sbt.mipt.oop.home.repository.SmartHomeRepository;
import ru.sbt.mipt.oop.home.repository.sources.impl.jsonSmartHomeSource;
import ru.sbt.mipt.oop.home.repository.sources.api.SmartHomeSource;
import ru.sbt.mipt.oop.events.provider.RandomEventProvider;
import java.io.IOException;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    private static SmartHomeSource source = new jsonSmartHomeSource();
    private static SmartHomeRepository repository = new SmartHomeRepository(source);

    public static void main(String... args) throws IOException {

        SmartHome smartHome = repository.loadSmartHome();
        runEventsCycle(smartHome);

    }

    private static void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = RandomEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
                // событие от источника света
                LightEventProcessor.proccessEvent(smartHome, event);
            }
            if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
                // событие от двери
                DoorEventProcessor.proccessEvent(smartHome, event);
            }
            event = RandomEventProvider.getNextSensorEvent();
        }
    }

    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }


}
