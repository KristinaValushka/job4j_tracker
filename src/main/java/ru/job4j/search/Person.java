package ru.job4j.search;

import java.util.ArrayList;

public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }


    public static void main(String[] args) {
        ArrayList<String> person = new ArrayList<>();
        person.add("Petr");
        person.add("Arsentev");
        person.add("534872");
        person.add("Bryansk");

        for (int i = 0; i < person.size(); i++) {
            boolean key = person.contains("Petr");
            if (key == true) {
                System.out.println("element Petr is contained in the list");
            } else {
                System.out.println("element Petr is not contained in the list");

            }
        }
    }
}
