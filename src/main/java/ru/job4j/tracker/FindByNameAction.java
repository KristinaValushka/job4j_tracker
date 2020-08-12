package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Found item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String key = input.askStr("Enter key: ");
        Item[] foundName = tracker.findByName(key);
        if(foundName.length > 0) {} else {}
        for (int i = 0; i < foundName.length; i++) {
            System.out.println("Операция выполнена успешно " + foundName[i] + "найденное имя");
        }
        System.out.println("Не удалось найти существующую заявку");
        return true;
    }
}
