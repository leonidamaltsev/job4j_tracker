package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int experience;

    public Dentist() {
        super();
    }

    public Dentist(String name, String surname, String education, String birthday, String specialization, int experience) {
        super(name, surname, education, birthday, specialization);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
}