package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String calculator;

    public Engineer(String name, String surname, String education, String birthday, String calculator) {
        super(name, surname, education, birthday);
        this.calculator = calculator;
    }

    public String getCalculator() {
        return calculator;
    }
}