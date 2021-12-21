package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book name1 = new Book("MuMu", 30);
        Book name2 = new Book("Clean water", 35);
        Book name3 = new Book("Clean code", 110);
        Book name4 = new Book("BBC", 15);
        Book[] books = {name1, name2, name3, name4};
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPage());
        }
        books[0] = name4;
        books[3] = name1;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPage());
        }
        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println(books[index].getName() + " - " + books[index].getPage());
            }
        }
    }
}