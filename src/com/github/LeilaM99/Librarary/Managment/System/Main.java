package com.github.LeilaM99.Librarary.Managment.System;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // افزودن کتاب‌ها
        library.addBook(new Book("Java Programming", "John Doe", "1234567890"));
        library.addBook(new Book("Data Structures", "Jane Smith", "0987654321"));

        // افزودن اعضا
        library.addMember(new Member("Alice", "M001"));
        library.addMember(new Member("Bob", "M002"));

        // امانت کتاب
        boolean borrowed = library.borrowBook("1234567890", library.getMembers().get(0));
        System.out.println("Borrowed: " + borrowed);

        // عودت کتاب
        boolean returned = library.returnBook("1234567890");
        System.out.println("Returned: " + returned);


    }
}