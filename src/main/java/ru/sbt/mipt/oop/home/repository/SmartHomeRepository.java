package ru.sbt.mipt.oop.home.repository;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.home.repository.sources.api.SmartHomeSource;

import java.io.IOException;

public class SmartHomeRepository {

    private SmartHomeSource source;

    public SmartHomeRepository(SmartHomeSource source) {
        this.source = source;
    }

    public SmartHomeSource getSource() {
        return source;
    }

    public void setSource(SmartHomeSource source) {
        this.source = source;
    }

    public void saveSmartHome() throws IOException {
        source.save();
    }

    public SmartHome loadSmartHome() throws IOException {
        return source.load();
    }
}
