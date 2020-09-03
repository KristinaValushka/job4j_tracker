package ru.job4j.tracker;

import java.util.List;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }
    public static void searchAll(Tracker tracker) {
        System.out.println("=== All item ===");
        List<Item> foundAll = tracker.findAll();
        for (int i = 0; i < foundAll.size(); i++) {
            System.out.println(foundAll.get(i));
        }
    }
    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Editing item ===");
        String name = input.askStr("Enter name: ");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item items = new Item(name);
        boolean replace = tracker.replace(id, items);
        if (replace) {
            System.out.println("Операция выполнена успешно");
        } else {
            System.out.println("Не удалось заменить существующий элемент");
        }
    }
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Deletion item ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        boolean deleteItem = tracker.delete(id);
        if (deleteItem) {
            System.out.println("Операция выполнена успешно " + deleteItem + " удлаен");
        } else {
            System.out.println("Не удалось удалить существующий элемент");
        }
    }
    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Found item by Id ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item founId = tracker.findById(id);
        if (founId != null) {
            System.out.println("Операция выполнена успешно " + founId + " найденная заявка");
        } else {
            System.out.println("Не удалось найти заявку по ID");
        }
    }
    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Found item by name");
        String key = input.askStr("Enter key: ");
        List<Item> foundName = tracker.findByName(key);
        if(foundName.size() > 0) {
            for (int i = 0; i < foundName.size(); i++) {
                System.out.println("Операция выполнена успешно " + foundName.get(i) + "найденное имя");
            }
        } else {
            System.out.println("Не удалось найти существующую заявку");
        }
    }

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0, 1, 2, 3, 4, 5 or 6 " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = {
                new CreateAction(output),
                new SearchAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        }
    }


