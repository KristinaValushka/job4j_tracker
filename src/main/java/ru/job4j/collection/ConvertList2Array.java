package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int i = 0;
       for (int row = 0; row < groups; row++){
                for (int cell = 0; cell < groups; cell++)
                    if (i >= list.size()) {
                        array[row][cell] = 0;
                    } else {
                        array[row][cell] = list.get(i++);
                    }
            }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}