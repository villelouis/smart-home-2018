package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.Alarm;

import java.util.ArrayList;
import java.util.Collection;


public class SmartHome implements Actionable{

    private Collection<Room> rooms;
    private Alarm alarm;

    public Alarm getAlarm() {
        return alarm;
    }

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void turnOffLights() {
        this.executeAction(object -> {
            if (object instanceof Light) {
                ((Light) object).setOn(false);
            }
        });
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        for (Room room : rooms) {
            room.executeAction(action);
        }
    }


}
