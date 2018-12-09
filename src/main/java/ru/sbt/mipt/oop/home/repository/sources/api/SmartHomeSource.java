package ru.sbt.mipt.oop.home.repository.sources.api;

import ru.sbt.mipt.oop.SmartHome;
import java.io.IOException;

public interface SmartHomeSource {
    public SmartHome load() throws IOException;
    public void save() throws IOException;
}
