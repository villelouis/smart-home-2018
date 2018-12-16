package ru.sbt.mipt.oop.decorators;

import ru.sbt.mipt.oop.event.processor.api.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.alarm.state.impl.ActivatedAlarmState;
import ru.sbt.mipt.oop.alarm.state.impl.AlarmModeAlarmState;


public class SMSSenderDecorator implements EventProcessor {
    final private EventProcessor processor;

    SMSSenderDecorator(EventProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (smartHome.getAlarm().getAlarmState() instanceof ActivatedAlarmState || smartHome.getAlarm().getAlarmState() instanceof AlarmModeAlarmState) {
            System.out.println("Sending sms message");
            return;
        }
        processor.processEvent(smartHome, event);
    }
}
