package ru.job4j.tracker;

public class FindByIdAction implements UserAction{

    private Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Found item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item founId = tracker.findById(id);
        if (founId != null) {
            out.println("Операция выполнена успешно " + founId + " найденная заявка");
        } else {
            out.println("Не удалось найти заявку по ID");
        }
        return true;
    }
}
