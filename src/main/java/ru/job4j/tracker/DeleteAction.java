package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Deletion item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter id: "));
        boolean deleteItem = tracker.delete(id);
        if (deleteItem) {
            out.println("Операция выполнена успешно " + deleteItem + " удлаен");
        } else {
            out.println("Не удалось удалить существующий элемент");
        }
        return true;
    }
}
