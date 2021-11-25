package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return eng;
    }

    public static void main(String[] args) {
        DummyDic booby = new DummyDic();
        String eng = booby.engToRus("Неизвестное слово");
        System.out.println(eng + " eng");
    }
}