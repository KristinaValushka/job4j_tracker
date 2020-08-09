package ru.job4j.tracker.ru.job4j.tracker;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);

            } else if (select == 1) {
                System.out.println("=== All item ===");
                Item[] foundAll = Tracker.findAll();
                for (int i = 0; i < foundAll.length; i++) {
                   System.out.println(foundAll[i]);
                }


            } else if (select == 2) {
                System.out.println("=== Editing item ===");
                int name = Integer.valueOf(scanner.nextLine());
                Item items = new Item(name);
                int id = Integer.valueOf(scanner.nextLine());
                boolean replace = Tracker.replace(id, items);

                if (replace) {
                    System.out.println("Операция выполнена успешно");
                } else {
                    System.out.println("Не удалось заменить существующий элемент");
                }

                } else if (select == 3) {
                System.out.println("=== Deletion item ===");
                int id = Integer.valueOf(scanner.nextLine());
                boolean deleteItem = Tracker.delete(id);
                if (deleteItem) {
                    System.out.println("Операция выполнена успешно " + deleteItem + " удлаен");
                } else {
                    System.out.println("Не удалось удалить существующий элемент");
                }
            } else if (select == 4) {
                System.out.println("=== Found item by Id ===");
                int id = Integer.valueOf(scanner.nextLine());
                Item founId = Tracker.findById(id);
                if (founId != null) {
                    System.out.println("Операция выполнена успешно " + founId + " найденная заявка");
                } else {
                    System.out.println("Не удалось найти заявку по ID");
                }


            } else if (select == 5) {
                System.out.println("=== Found item by name");
                String key = scanner.nextLine();
                Item[] foundName = Tracker.findByName(key);
                for (int i = 0; i < foundName.length; i++) {
                    if (foundName != null) {
                        System.out.println("Операция выполнена успешно " + foundName[i] + "найденное имя");
                    } else {
                        System.out.println("Не удалось найти существующую заявку");
                    }
                    System.out.println(foundName[i]);
                }

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
        /* добавить остальные пункты меню. */

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);

    }
}
