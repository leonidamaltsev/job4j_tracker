package ru.job4j.oop;

import java.sql.SQLOutput;

public class Max {
    public static int max(int first, int second) {
        return first > second ? first : second;
    }

    public static int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    public static int max(int first, int second, int third, int fourth) {
        return max(first, second, max(third, fourth));
    }

    public static void main(String[] args) {
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = 4;
        int rsl = Max.max(first, second, third, fourth);
        System.out.println(rsl);
    }
}