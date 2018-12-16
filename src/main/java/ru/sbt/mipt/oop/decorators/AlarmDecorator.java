package ru.sbt.mipt.oop.decorators;

import ru.sbt.mipt.oop.event.processor.api.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.alarm.state.impl.ActivatedAlarmState;
import ru.sbt.mipt.oop.alarm.state.impl.AlarmModeAlarmState;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

public class AlarmDecorator implements EventProcessor {
    final private EventProcessor processor;

    AlarmDecorator(EventProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {

        if (smartHome.getAlarm().getAlarmState() instanceof ActivatedAlarmState && !isAlarmEvent(event)) {
            smartHome.getAlarm().setAlarmMode();
        }
        if (smartHome.getAlarm().getAlarmState() instanceof AlarmModeAlarmState) {
            return;
        }
        processor.processEvent(smartHome, event);

    }

    private boolean isAlarmEvent(SensorEvent event) {
        return event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE;
    }
}
