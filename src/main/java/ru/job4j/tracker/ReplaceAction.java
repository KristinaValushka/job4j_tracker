package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    private Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Editing item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item items = new Item(name);
        int id = Integer.parseInt(input.askStr("Enter id: "));
        boolean replace = tracker.replace(id, items);
        if (replace) {
            out.println("Операция выполнена успешно");
        } else {
            out.println("Не удалось заменить существующий элемент");
        }return true;
    }
}
