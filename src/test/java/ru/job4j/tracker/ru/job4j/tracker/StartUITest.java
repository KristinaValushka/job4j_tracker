package ru.job4j.tracker.ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = .... ?
        assertThat(created.getName(), is(expected.getName()));
    }
}

