package ru.job4j.collection;

import ru.job4j.tracker.Input;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] row : list) {
            for (Integer cell : row) {
                rsl.add(cell);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
    }
}

