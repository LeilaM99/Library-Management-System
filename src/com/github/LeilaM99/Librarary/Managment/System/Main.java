package com.github.LeilaM99.Librarary.Managment.System;


public class Main {
    public static void main(String[] args) {
        Library library = new Library(5, 5);

        // add book
        library.addBook(new Book("Midnight Xrary", "Mat Haig", "ISBN001"));
        library.addBook(new Book("Johnathan Livingston seagull", "Richard Bach", "ISBN002"));

        // add member
        library.addMember(new Member("Lili", "M001"));
        library.addMember(new Member("Sisi", "M002"));

        // showing mems and books
        System.out.println("Books in the library:");
        library.displayBooks();

        System.out.println("\nMembers of the library:");
        library.displayMembers();

        // edit book
        library.editBook(0, new Book("Midnight Library", "Matt Haig", "ISBN001"));

        // edit mem
        library.editMember(1, new Member("Sogand", "M002"));

        // redisplay mems and books
        System.out.println("\nUpdated Books in the library:");
        library.displayBooks();

        System.out.println("\nUpdated Members of the library:");
        library.displayMembers();
    }

}