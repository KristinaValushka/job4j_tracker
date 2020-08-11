package ru.job4j.tracker;

public class SearchAllAction implements UserAction {
    @Override
    public String name() {
        return "=== All item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] foundAll = tracker.findAll();
        for (int i = 0; i < foundAll.length; i++) {
            System.out.println(foundAll[i]);
        }
        return true;
    }
}
