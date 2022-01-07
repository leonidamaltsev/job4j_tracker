package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Едет по шоссе");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " Запрввляется бензином");
    }
}
