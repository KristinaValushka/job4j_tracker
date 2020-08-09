package ru.job4j.tracker;
import java.util.Arrays;

public class Tracker {
    private static final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = Arrays.copyOf(items, this.size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] itemsName = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
        if (items[i].getName().equals(key); {
                itemsName[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(itemsName, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;

        } return index != - 1;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < this.size; index++) {
            if (items[index].getId() == id) {
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
            System.arraycopy(items, index + 1, items, index, this.size - index);
            items[this.size - 1] = null;
            this.size--;
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