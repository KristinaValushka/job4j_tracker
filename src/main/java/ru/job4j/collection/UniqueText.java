package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split("");
        String[] text = duplicateText.split("");
        HashSet<String> check = new HashSet<>();
        for (String or : origin) {
            check.add(or);
        }
        for (String tx = text) {
            rsl = check.contains(tx);
            if (!rsl) {
                break;
            }
        }
           return rsl;
    }
}