package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book name1 = new Book("MuMu", 30);
        Book name2 = new Book("Clean water", 35);
        Book name3 = new Book("Clean code", 110);
        Book name4 = new Book("BBC", 15);
        Book[] books = new Book[4];
        books[0] = name1;
        books[1] = name2;
        books[2] = name3;
        books[3] = name4;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPage());
        }
        System.out.println("Replace MuMu to BBC");
        books[0] = name4;
        books[3] = name1;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPage());
        }
        System.out.println("Show only book Clean code");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getPage());
            }
        }
    }
}