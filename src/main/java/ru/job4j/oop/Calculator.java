package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperations(int c) {
        return sum(c) + minus(c) + multiply(c) + divide(c);
    }

    public static void main(String[] args) {
        int result1 = sum(10);
        System.out.println(result1);
        int result2 = minus(7);
        System.out.println(result2);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(3);
        System.out.println(rsl);
        int rsl1 = calculator.divide(3);
        System.out.println(rsl1);
        int rsl2 = calculator.sumAllOperations(1);
        System.out.println(rsl2);
    }
}