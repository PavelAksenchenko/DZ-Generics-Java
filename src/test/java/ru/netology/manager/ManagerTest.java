package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Tickets;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Tickets first = new Tickets(15, 15000, "DME", "IKT", 5);
    Tickets second = new Tickets(600, 4500, "VKO", "AER", 2);
    Tickets third = new Tickets(81, 5000, "VKO", "AER", 2);
    Tickets fourth = new Tickets(555, 10000, "DME", "IKT", 5);
    Tickets fifth = new Tickets(556, 10000, "DME", "IST", 4);


    @Test
    void shouldFindAll() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);

        Tickets[] expected = {first, second, third, fourth};
        Assertions.assertArrayEquals(expected, repo.findAll());

    }

    @Test
    void shouldFindDME() {
        manager.addItem(first);
        manager.addItem(second);
        manager.addItem(third);
        manager.addItem(fourth);

        Tickets[] expected = {fourth, first};
        assertArrayEquals(expected, manager.getAll("DME", "IKT"));

    }

    @Test
    void shouldFindVKO() {
        manager.addItem(first);
        manager.addItem(second);
        manager.addItem(third);
        manager.addItem(fourth);

        Tickets[] expected = {second, third};
        assertArrayEquals(expected, manager.getAll("VKO", "AER"));

    }

    @Test
    void shouldFindNonExisting() {
        manager.addItem(first);
        manager.addItem(second);
        manager.addItem(third);
        manager.addItem(fourth);
        manager.addItem(fifth);

        Tickets[] expected = {};
        assertArrayEquals(expected, manager.getAll("VKO", "DME"));

    }
}