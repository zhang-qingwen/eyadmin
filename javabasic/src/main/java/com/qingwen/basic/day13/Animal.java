package com.qingwen.basic.day13;

public class Animal {
    private String name;
    private String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return this.toString() == o.toString();
    }

    @Override
    public int hashCode() {
        return 11;
    }
}
