package ru.sbt.mipt.oop.remote.controll;

import ru.sbt.mipt.oop.remote.controll.api.RemoteControl;

public interface RemoteControlRegistry {
    void registerRemoteControl(RemoteControl remoteControl, String rcId);
}
