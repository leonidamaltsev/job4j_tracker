package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullname("Ivan Ivanov");
        student.setGroup("203");
        student.setReceipt(new Date());

        System.out.println(student.getFullname() + "," + " Группа № " + student.getGroup() + ", " + student.getReceipt());
    }
}