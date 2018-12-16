package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.List;

public class TestSmartHome {
    public static SmartHome init() {
        List<Door> doors = new ArrayList<>();
        doors.add(new Door(true, "1"));
        doors.add(new Door(false, "2"));
        List<Light> lights = new ArrayList<>();
        lights.add(new Light(true, "1"));
        lights.add(new Light(false, "2"));
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(lights, doors, "hall"));
        return new SmartHome(rooms);
    }
}