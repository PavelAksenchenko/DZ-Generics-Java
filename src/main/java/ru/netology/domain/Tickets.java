package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tickets implements Comparable<Tickets> {
    private int id;
    private int price;
    private String depart;
    private String arrive;
    private int duration;

    @Override
    public int compareTo(Tickets o) {
        return this.price - o.price;
    }
}