package com.github.LeilaM99.Librarary.Managment.System;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // افزودن کتاب‌ها
        library.addBook(new Book("Midnight Library", "Matt Haig", "001"));
        library.addBook(new Book("Johnathan Livingston seagull", "Richard Bach", "002"));

        // افزودن اعضا
        library.addMember(new Member("Lili", "M001"));
        library.addMember(new Member("Sogand", "M002"));

        // امانت کتاب
        boolean borrowed = library.borrowBook("001", library.getMembers().get(0));
        System.out.println("Borrowed: " + borrowed);

        // عودت کتاب
        boolean returned = library.returnBook("001");
        System.out.println("Returned: " + returned);


    }
}