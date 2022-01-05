package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println();
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("количество пассажиров " + passengers);
    }

    @Override
    public double refuel(double fuel, double price) {
        return fuel * price;
    }
}