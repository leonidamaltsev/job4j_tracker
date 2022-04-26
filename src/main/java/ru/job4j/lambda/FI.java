package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };

        Comparator<Attachment> comparator = (left, right) -> Integer.compare(left.getSize(), right.getSize());
        System.out.println("По длине:" + comparator);
        Arrays.sort(atts, comparator);

        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        System.out.println("Через метод compareTo:" + cmpText);

        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        System.out.println("По убыванию длины:" + cmpDescSize);
    }
}