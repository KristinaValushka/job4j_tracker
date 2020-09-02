package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private static final List<Item> items = new ArrayList<>();

    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);

        return item;
    }

    public List<Item> findAll() {
        List<Item> itemsWithoutNull = Arrays.copyOf(items, this.size);
        return itemsWithoutNull;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsName = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
        if (items.get(i).getName().equals(key)); {
                itemsName[size] = items.get(i);
                size++;
            }
        }
        return Arrays.copyOf(itemsName, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);

        } return index != - 1;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < this.size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
    }

}