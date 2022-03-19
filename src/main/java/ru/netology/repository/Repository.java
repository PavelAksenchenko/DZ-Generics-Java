package ru.netology.repository;

import ru.netology.domain.Tickets;

public class Repository {

    private Tickets[] items = new Tickets[0];

    public void save(Tickets item) {
        int length = items.length + 1;
        Tickets[] tmp = new Tickets[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Tickets[] findAll() {
        return items;
    }

    public Tickets findById(int id) {

        for (Tickets item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public void removeById(int id) {

        int length = items.length - 1;
        Tickets[] tmp = new Tickets[length];
        int index = 0;
        for (Tickets item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;

    }
}