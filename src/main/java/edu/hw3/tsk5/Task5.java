package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


class Contact {
    private final String name;
    private final String surname;

    public Contact(String name) {
        this.name = name;
        this.surname = null;
    }

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}


public class Task5 {
    private static boolean ASC = true;
    private static boolean DESC = false;

    private Task5() {
    }

    public static List<Contact> parseContacts(String[] people, String order) {
        boolean ord = ASC;
        if (Objects.equals(order, "DESC")) {
            ord = DESC;
        } else if (!Objects.equals(order, "ASC")) {
            return null;
        }
        List<Contact> contacts = new ArrayList<>();
        for (String person : people) {
            if (person == null) {
                contacts.add(null);
                continue;
            }
            String[] name = person.split("\\s+", 2);
            if (name.length == 1) {
                contacts.add(new Contact(name[0]));
            } else {
                contacts.add(new Contact(name[0], name[1]));
            }
        }
        contacts.sort((o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return -1;
            } else if (o2 == null) {
                return 1;
            }
            String name1 = o1.getSurname();
            if (name1 == null) {
                name1 = o1.getName();
            }

            String name2 = o2.getSurname();
            if (name2 == null) {
                name2 = o2.getName();
            }
            return name1.compareTo(name2);
        });
        return ord ? contacts.reversed() : contacts;
    }
}
