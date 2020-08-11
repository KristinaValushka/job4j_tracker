package ru.job4j.tracker;

public class FindByIdItem implements UserAction{
    @Override
    public String name() {
        return "=== Found item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter id: "));
        Item founId = tracker.findById(id);
        if (founId != null) {
            System.out.println("Операция выполнена успешно " + founId + " найденная заявка");
        } else {
            System.out.println("Не удалось найти заявку по ID");
        }
        return true;
    }
}
