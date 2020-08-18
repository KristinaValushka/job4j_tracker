package ru.job4j.tracker;

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
        Item[] foundAll = tracker.findAll();
        for (int i = 0; i < foundAll.length; i++) {
            out.println("Найдены следующие заявки: " + foundAll[i]);
        }
        return true;
    }
}
