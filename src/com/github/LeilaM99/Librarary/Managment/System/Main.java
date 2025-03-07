package com.github.LeilaM99.Librarary.Managment.System;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(5, 5);

        // add book
        library.addBook(0,new Book("Midnight Xrary", "Mat Haig", "ISBN001"));
        library.addBook(1,new Book("Johnathan Livingston seagull", "Richard Bach", "ISBN002"));

        // add member
        library.addMember(new Member("Lili", "M001"));
        library.addMember(new Member("Sisi", "M002"));

        // showing mems and books
        System.out.println("Books in the library:");
        library.displayBooks();

        System.out.println("\nMembers of the library:");
        library.displayMembers();

        // edit book
        library.editBook(0,new Book ("Midnight Library", "Matt Haig", "ISBN001"));

        // edit mem
        library.editMember(1, new Member("Sogand", "M002"));

        // redisplay mems and books
        System.out.println("\nUpdated Books in the library:");
        library.displayBooks();

        System.out.println("\nUpdated Members of the library:");
        library.displayMembers();
    }
//        Library library = new Library();
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//
//        do {
//            System.out.println("1. Add Book");
//            System.out.println("2. Remove Book");
//            System.out.println("3. Edit Book");
//            System.out.println("4. Display Books");
//            System.out.println("5. Check Out Book");
//            System.out.println("6. Return Book");
//            System.out.println("0. Exit");
//            System.out.print("Enter your choice: ");
//            choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter book title: ");
//                    String title = scanner.nextLine();
//                    System.out.print("Enter book author: ");
//                    String author = scanner.nextLine();
//                    System.out.print("Enter isbn : ");
//                    String isbn = scanner.nextLine();
//                    library.addBook(new Book(title, author, isbn));//doroste?//
//                    break;
//                case 2:
//                    System.out.print("Enter book title to remove: ");
//                    String removeTitle = scanner.nextLine();
//                    library.removeBook(removeTitle);
//                    break;
//                case 3:
//                    System.out.print("Enter index to edit: ");
//                    int index = scanner.nextInt();
//                    System.out.print("Enter old book title to edit: ");
//                    String oldTitle = scanner.nextLine();
//                    System.out.print("Enter new book title: ");
//                    String newTitle = scanner.nextLine();
//                    System.out.print("Enter new book author: ");
//                    String newAuthor = scanner.nextLine();
//                    library.editBook(index,oldTitle, newTitle, newAuthor);
//                    break;
//                case 4:
//                    library.displayBooks();
//                    break;
//                case 5:
//                    System.out.print("Enter book title to check out: ");
//                    String checkOutTitle = scanner.nextLine();
//                    library.checkOutBook(checkOutTitle);
//                    break;
//                case 6:
//                    System.out.print("Enter book title to return: ");
//                    String returnTitle = scanner.nextLine();
//                    library.returnBook(returnTitle);
//                    break;
//                case 0:
//                    System.out.println("Exiting...");
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        } while (choice != 0);
//
//
//    }
}


