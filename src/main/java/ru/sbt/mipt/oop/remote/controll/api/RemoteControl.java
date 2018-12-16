package ru.sbt.mipt.oop.remote.controll.api;

public interface RemoteControl {
    void onButtonPressed(String buttonCode); // код нажатой кнопки: “A”, “B”, “C”, “D”, “1”, “2”, “3”, “4”
}
