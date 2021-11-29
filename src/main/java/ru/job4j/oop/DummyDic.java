package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        eng = ("Неизвестное слово. " + eng);
        return eng;
    }

    public static void main(String[] args) {
        DummyDic flash = new DummyDic();
        String eng = flash.engToRus("eng");
        System.out.println(eng);
    }
}