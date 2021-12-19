package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String specification;
    private int salary;

    public Builder(String name, String surname, String education, String birthday, String calculator, String specification, int salary) {
        super(name, surname, education, birthday, calculator);
        this.specification = specification;
        this.salary = salary;
    }

    public String getSpecification() {
        return specification;
    }

    public int getSalary() {
        return salary;
    }
}