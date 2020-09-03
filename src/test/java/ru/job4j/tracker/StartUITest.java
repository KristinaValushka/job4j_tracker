package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/*public class StartUITest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "4", "0" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. == Exit ==%n"
                                + "Wrong input, you can select: 0, 1, 2, 3, 4, 5 or 6 0%n"
                                + "Menu.%n"
                                + "0. == Exit ==%n"
                )
        ));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("Replaced item"));

        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", replacedName, "1", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput (
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);

        assertThat(out.toString(), is(
                "Menu." + LN +
                        "0. == Exit ==" + LN
        ));
    }
    @Test
    public void testSearchAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new SearchAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN + "0. === All item ===" + LN + "1. == Exit ==" + LN
                        + "Menu." + LN + "0. === All item ===" + LN + "1. == Exit ==" + LN
        ));
    }
    @Test
    public void testFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );

        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String expected = "Menu." + LN
                + "0. === Found item by Id ===" + LN + "1. == Exit ==" + LN
                + "Операция выполнена успешно Item{id=1, name='test1'} найденная заявка" + LN
                + "Menu." + LN + "0. === Found item by Id ===" + LN
                + "1. == Exit ==" + LN;
        assertThat(out.toString(), is(expected));
    }
    @Test
    public void testFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","1","1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String expected = "Menu." + LN +  "0. === Found item by name ===" + LN
                + "1. == Exit ==" + LN + "Не удалось найти существующую заявку "
                + LN + "Menu." + LN +  "0. === Found item by name ==="
                + LN + "1. == Exit ==" + LN;
        assertThat(out.toString(), is(expected));
    }
}*/