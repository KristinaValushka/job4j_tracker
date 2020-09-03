package ru.job4j.tracker;

import java.util.List;

public class SearchAllAction implements UserAction{
    private Output out;

    public SearchAllAction(Output out) {
    this.out = out;
    }

    @Override
    public String name() {
        return "=== All item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> foundAll = tracker.findAll();
        for (int i = 0; i < foundAll.size(); i++) {
            out.println("Найдены следующие заявки: " + foundAll.get(i));
        }
        return true;
    }
}
