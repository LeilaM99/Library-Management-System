package com.github.LeilaM99.Librarary.Managment.System.controler;

import com.github.LeilaM99.Librarary.Managment.System.dS.Node; import com.github.LeilaM99.Librarary.Managment.System.entity.Book; import com.github.LeilaM99.Librarary.Managment.System.entity.Gender; import com.github.LeilaM99.Librarary.Managment.System.entity.User; import com.github.LeilaM99.Librarary.Managment.System.exception.InvalidInputException; import com.github.LeilaM99.Librarary.Managment.System.exception.NotFoundException; import com.github.LeilaM99.Librarary.Managment.System.service.Library;

import java.util.InputMismatchException; import java.util.Scanner;

public class LibraryControler {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            try {
                choice = getInt("Enter your choice: ");
                handleChoice(choice);
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                choice = -1;
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                choice = -1;
            }
        } while (choice != 0);

        System.out.println("Exiting program.");
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
        try {
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
                default -> throw new InvalidInputException("Invalid menu option selected.");
            }
        } catch (NotFoundException | InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addBook() throws InvalidInputException {
        String title = getString("Enter book title: ");
        String author = getString("Enter book author: ");
        library.addBook(new Book(title, author));
    }

    private static void removeBook() throws NotFoundException, InvalidInputException {
        String title = getString("Enter book title to remove: ");
        Book book = findBookByTitle(title);
        if (book != null) library.removeBook(book);
    }

    private static void updateBook() throws NotFoundException, InvalidInputException {
        String title = getString("Enter current book title: ");
        Book book = findBookByTitle(title);
        if (book != null) {
            String newTitle = getString("Enter new title: ");
            String newAuthor = getString("Enter new author: ");
            library.updateBook(book, newTitle, newAuthor);
        }
    }

    private static void addUser() throws InvalidInputException {
        String name = getString("Enter user name: ");
        int id = getInt("Enter user ID: ");
        Gender gender = getGender();
        library.addUser(new User(name, id, gender));
    }

    private static void removeUser() throws NotFoundException, InvalidInputException {
        int id = getInt("Enter user ID to remove: ");
        User user = findUserById(id);
        if (user != null) library.removeUser(user);
    }
    private static void updateUser() throws NotFoundException, InvalidInputException {
        int id = getInt("Enter current user ID: ");
        User user = findUserById(id);
        if (user != null) {
            String newName = getString("Enter new name: ");
            Gender newGender = getGender();
            library.updateUser(user, newName, newGender);
        }
    }

    private static void borrowBook() throws NotFoundException, InvalidInputException {
        int id = getInt("Enter user ID: ");
        String title = getString("Enter book title: ");
        User user = findUserById(id);
        Book book = findBookByTitle(title);
        if (user != null && book != null) {
            library.borrowBook(user, book);
        }
    }

    private static void returnBook() throws NotFoundException, InvalidInputException {
        int id = getInt("Enter user ID: ");
        String title = getString("Enter book title to return: ");
        User user = findUserById(id);
        Book book = findBookByTitle(title);
        if (user != null && book != null) {
            library.returnBook(user, book);
        }
    }

    private static String getString(String prompt) throws InvalidInputException {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) throw new InvalidInputException("Input cannot be empty.");
        return input;
    }

    private static int getInt(String prompt) throws InvalidInputException {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Input must be a valid number.");
        }
    }

    private static Gender getGender() throws InvalidInputException {
        System.out.print("Enter gender (MALE/FEMALE): ");
        try {
            return Gender.valueOf(scanner.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException("Invalid gender. Use MALE or FEMALE.");
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

}