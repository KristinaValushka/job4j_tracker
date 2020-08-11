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
        Item items = new Item(name);
        int id = Integer.valueOf(input.askStr("Enter id: "));
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
    public static void findByIdItem(Input input, Tracker tracker) {
        System.out.println("=== Found item by Id ===");
        int id = Integer.valueOf(input.askStr("Enter id: "));
        Item founId = tracker.findById(id);
        if (founId != null) {
            System.out.println("Операция выполнена успешно " + founId + " найденная заявка");
        } else {
            System.out.println("Не удалось найти заявку по ID");
        }
    }
    public static void findByNameItem(Input input, Tracker tracker) {
        System.out.println("=== Found item by name");
        String key = input.askStr("Enter key: ");
        Item[] foundName = tracker.findByName(key);
        if(foundName.length > 0) {} else {}
        for (int i = 0; i < foundName.length; i++) {
             System.out.println("Операция выполнена успешно " + foundName[i] + "найденное имя");
            }
          System.out.println("Не удалось найти существующую заявку");
        }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.searchAll(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findByIdItem(input, tracker);
            } else if (select == 5) {
                StartUI.findByNameItem(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);

    }
}
