package ru.netology.manager;

import ru.netology.domain.Tickets;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class Manager {
    private Repository repository;


    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void addItem(Tickets item) {
        repository.save(item);
    }

    public Tickets[] getAll(String depart, String arrive) {
        Tickets[] result = new Tickets[0];
        for (Tickets item : repository.findAll()
        ) {
            if (depart.equals(item.getDepart()) && arrive.equals(item.getArrive())) {
                Tickets[] tmp = new Tickets[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }

        Arrays.sort(result);
        return result;

    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}