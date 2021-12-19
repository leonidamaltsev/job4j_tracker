package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private char gender;

    public Surgeon(String name, String surname, String education, String birthday, String specialization, char gender) {
        super(name, surname, education, birthday, specialization);
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }
}