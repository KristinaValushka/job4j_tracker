package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction{

    private Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Found item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String key = input.askStr("Enter key: ");
        List<Item> foundName = tracker.findByName(key);
        if(foundName.size() > 0) {
            for (int i = 0; i < foundName.size(); i++) {
                out.println("Операция выполнена успешно " + foundName.get(i));
            }
        } else {
            out.println("Не удалось найти существующую заявку ");
        }
        return true;
    }
}
