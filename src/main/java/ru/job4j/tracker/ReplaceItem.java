package ru.job4j.tracker;

public class ReplaceItem implements UserAction{
    @Override
    public String name() {
        return "=== Editing item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item items = new Item(name);
        int id = Integer.valueOf(input.askStr("Enter id: "));
        boolean replace = tracker.replace(id, items);
        if (replace) {
            System.out.println("Операция выполнена успешно");
        } else {
            System.out.println("Не удалось заменить существующий элемент");
        }return true;
    }
}
