package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int minus(int y) {
        return x - y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int b) {
        return x / b;
    }

    public int sumAllOperations(int c) {
        return minus(2) + multiply(3) + divide(5);
    }

    public static void main(String[] args) {
        int result = minus(2);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(3);
        System.out.println(rsl);
        int rsl1 = calculator.divide(3);
        System.out.println(rsl1);
        int rsl2 = calculator.sumAllOperations(1);
        System.out.println(rsl2);
    }
}