package ru.sbt.mipt.oop.home.repository.sources.impl;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.home.repository.sources.api.SmartHomeSource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.Path;

public class jsonSmartHomeSource implements SmartHomeSource {

    private String path;
    private String workingPath;
    private SmartHome smartHome;

    public void setPath(String path) {
        this.path = path;
    }

    public void setWorkingPath(String workingPath) {
        this.workingPath = workingPath;
    }

    public void setSmartHome(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public jsonSmartHomeSource(String path, String savePath) {
        this.path = path;
        this.workingPath = savePath;
        this.smartHome = null;
    }

    public jsonSmartHomeSource(String path) {
        this.path = path;
        this.workingPath = path;
        this.smartHome = null;
    }

    public jsonSmartHomeSource() {
        this.path = "smart-home-1.json";
        this.workingPath = "smart-home-1.json";
        this.smartHome = null;
    }

    @Override
    public SmartHome load() throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(path)));
        if (smartHome == null){
            smartHome = gson.fromJson(json, SmartHome.class);
            System.out.println("Для сохранения состояния дома был задан файл по-умолчанию:"+workingPath);
        }
        return gson.fromJson(json, SmartHome.class);
    }

    @Override
    public void save() throws IOException {
        if (smartHome == null){
            throw new NullPointerException("Необходимо задать объект SmartHome для сохранения");
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        Path pathToFile = Paths.get(workingPath);

        try (BufferedWriter writer = Files.newBufferedWriter(pathToFile)) {
            writer.write(jsonString);
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
}
