package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Едет по рельсам");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " Движется электротягой");
    }
}
