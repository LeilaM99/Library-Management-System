package com.github.LeilaM99.Librarary.Managment.System;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // add book
        library.addBook(new Book("Midnight Library", "Matt Haig", "001"));
        library.addBook(new Book("Johnathan Livingston seagull", "Richard Bach", "002"));

        // add member
        library.addMember(new Member("Lili", "M001"));
        library.addMember(new Member("Sogand", "M002"));

        // borrowed book
        boolean borrowed = library.borrowBook("001", library.getMembers().get(0));
        System.out.println("Borrowed: " + borrowed);

        // Return book
        boolean returned = library.returnBook("001");
        System.out.println("Returned: " + returned);


    }
}