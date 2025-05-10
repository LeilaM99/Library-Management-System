package com.github.LeilaM99.Librarary.Managment.System;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = getInt("Enter your choice: ");
            handleChoice(choice);
        } while (choice != 0);

        System.out.println("Exiting program. Goodbye!");
    }

    private static void printMenu() {
        System.out.println("\n===== Library Menu =====");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Update Book");
        System.out.println("4. Display Available Books");
        System.out.println("5. Display Borrowed Books");
        System.out.println("6. Add User");
        System.out.println("7. Remove User");
        System.out.println("8. Update User");
        System.out.println("9. Display Users");
        System.out.println("10. Borrow Book");
        System.out.println("11. Return Book");
        System.out.println("0. Exit");
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1 -> addBook();
            case 2 -> removeBook();
            case 3 -> updateBook();
            case 4 -> library.displayAvailableBooks();
            case 5 -> library.displayBorrowedBooks();
            case 6 -> addUser();
            case 7 -> removeUser();
            case 8 -> updateUser();
            case 9 -> library.displayUsers();
            case 10 -> borrowBook();
            case 11 -> returnBook();
            case 0 -> System.out.println("Saving data...");
            default -> System.out.println("Invalid choice. Try again.");
        }
    }

    private static void addBook() {
        String title = getString("Enter book title: ");
        String author = getString("Enter book author: ");
        library.addBook(new Book(title, author));
    }

    private static void removeBook() {
        String title = getString("Enter book title to remove: ");
        Book book = findBookByTitle(title);
        if (book != null) library.removeBook(book);
    }

    private static void updateBook() {
        String title = getString("Enter current book title: ");
        Book book = findBookByTitle(title);
        if (book != null) {
            String newTitle = getString("Enter new title: ");
            String newAuthor = getString("Enter new author: ");
            library.updateBook(book, newTitle, newAuthor);
        }
    }

    private static void addUser() {
        String name = getString("Enter user name: ");
        int id = getInt("Enter user ID: ");
        Gender gender = getGender();
        library.addUser(new User(name, id, gender));
    }

    private static void removeUser() {
        int id = getInt("Enter user ID to remove: ");
        User user = findUserById(id);
        if (user != null) library.removeUser(user);
    }

    private static void updateUser() {
        int id = getInt("Enter current user ID: ");
        User user = findUserById(id);
        if (user != null) {
            String newName = getString("Enter new name: ");
            Gender newGender = getGender();
            library.updateUser(user, newName, newGender);
        }
    }

    private static void borrowBook() {
        int id = getInt("Enter user ID: ");
        String title = getString("Enter book title: ");
        User user = findUserById(id);
        Book book = findBookByTitle(title);
        if (user != null && book != null) {
            library.borrowBook(user, book);
        }
    }

    private static void returnBook() {
        int id = getInt("Enter user ID: ");
        String title = getString("Enter book title: ");
        User user = findUserById(id);
        Book book = findBookByTitle(title);
        if (user != null && book != null) {
            library.returnBook(user, book);
        }
    }

    private static Book findBookByTitle(String title) {
        Node<Book> current = library.books.head;
        while (current != null) {
            if (current.data.getTitle().equalsIgnoreCase(title)) {
                return current.data;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
        return null;
    }

    private static User findUserById(int id) {
        Node<User> current = library.users.head;
        while (current != null) {
            if (current.data.getUserId() == id) {
                return current.data;
            }
            current = current.next;
        }
        System.out.println("User not found.");
        return null;
    }

    private static Gender getGender() {
        System.out.println("Select gender:");
        System.out.println("1. MALE\n2. FEMALE\n3. OTHER");
        int g = getInt("Choice: ");
        return switch (g) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.OTHER;
            default -> Gender.OTHER;
        };
    }

    private static String getString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private static int getInt(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        return value;
    }
}

