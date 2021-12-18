package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private int cupsOfCoffee;

    public Programmer() {
        super();
    }

    public Programmer(String name, String surname, String education, String birthday, String calculator, int cupsOfCoffee) {
        super(name, surname, education, birthday, calculator);
        this.cupsOfCoffee = cupsOfCoffee;
    }

    public int getCupsOfCoffee() {
        return cupsOfCoffee;
    }
}