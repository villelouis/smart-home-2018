package ru.sbt.mipt.oop;

import org.junit.Before;
import org.junit.Test;


import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;
import ru.sbt.mipt.oop.remote.controll.impl.HomeRemoteControl;
import ru.sbt.mipt.oop.command.api.Command;
public class HomeRemoteControlTest {
    private HomeRemoteControl homeRemoteControl;
    private Command command;

    @Before
    public void init() {
        homeRemoteControl = new HomeRemoteControl();
        command = mock(Command.class);
    }

    private HashMap<String, Command> getHashMap() throws NoSuchFieldException, IllegalAccessException {
        Field hashMapObject = HomeRemoteControl.class.getDeclaredField("buttons");
        hashMapObject.setAccessible(true);
        HashMap<String, Command> hashMap = (HashMap<String, Command>) hashMapObject.get(homeRemoteControl);
        return hashMap;
    }

    @Test
    public void setCommandOnButtonTest_success() throws NoSuchFieldException, IllegalAccessException {
        homeRemoteControl.setCommandOnButton("A", command);
        HashMap hashMap = getHashMap();
        assertEquals(1, hashMap.size());
        assertSame(hashMap.get("A"), command);
    }

    @Test
    public void setCommandOnButtonTest_fail() throws NoSuchFieldException, IllegalAccessException {
        homeRemoteControl.setCommandOnButton("F", command);
        HashMap hashMap = getHashMap();
        assertEquals(0, hashMap.size());
    }

    @Test
    public void onButtonPressedTest_success() {
        Command command = mock(Command.class);
        doNothing().when(command).execute();
        homeRemoteControl.setCommandOnButton("A", command);
        homeRemoteControl.onButtonPressed("A");
        verify(command, times(1)).execute();
    }

    @Test
    public void onButtonPressedTest_fail_notRegisteredButton() {
        Command command = mock(Command.class);
        doNothing().when(command).execute();
        homeRemoteControl.setCommandOnButton("A", command);
        homeRemoteControl.onButtonPressed("F");
        verify(command, times(0)).execute();
    }
}
