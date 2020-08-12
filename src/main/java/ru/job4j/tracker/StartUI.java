package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }
    public static void searchAll(Tracker tracker) {
        System.out.println("=== All item ===");
        Item[] foundAll = tracker.findAll();
        for (int i = 0; i < foundAll.length; i++) {
            System.out.println(foundAll[i]);
        }
    }
    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Editing item ===");
        String name = input.askStr("Enter name: ");
        int id = Integer.valueOf(input.askStr("Enter id: "));
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
        int id = Integer.valueOf(input.askStr("Enter id: "));
        boolean deleteItem = tracker.delete(id);
        if (deleteItem) {
            System.out.println("Операция выполнена успешно " + deleteItem + " удлаен");
        } else {
            System.out.println("Не удалось удалить существующий элемент");
        }
    }
    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Found item by Id ===");
        int id = Integer.valueOf(input.askStr("Enter id: "));
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
        Item[] foundName = tracker.findByName(key);
        if(foundName.length > 0) {
            for (int i = 0; i < foundName.length; i++) {
                System.out.println("Операция выполнена успешно " + foundName[i] + "найденное имя");
            }
        } else {
            System.out.println("Не удалось найти существующую заявку");
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new SearchAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()

        };
        new StartUI().init(input, tracker, actions);
        }
    }


