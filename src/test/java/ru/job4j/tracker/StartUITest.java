package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        String[] answers = {"Fix PC"};  // создаем массив ответов, которые вводятся с консоли
        Input input = new StubInput(answers); // объект заглушки в которую помещаем ответы, которые будут извлекаться
        Tracker tracker = new Tracker();  // создаем объект класса tracker
        StartUI.createItem(input, tracker); //  вызываем метод который создает заявку, туда помещаем input и tracker
        Item created = tracker.findAll()[0]; // из трекера подучаем все заявки, а потом первую из них
        Item expected = new Item("Fix PC"); // создаем объект для сравнения
        assertThat(created.getName(), is(expected.getName())); // сравниваем имена объектов
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), // id сохраненной заявки в объект tracker.
                "replaced item",
                "new item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void testDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("null");
        tracker.add(item);            // теперь у нас есть id
        String[] answers = {
                String.valueOf(item.getId()), // id сохраненной заявки в объект tracker.
                "deleted item",
                "null"                         // массив ответов
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted.getName(), is("null"));
    }
}