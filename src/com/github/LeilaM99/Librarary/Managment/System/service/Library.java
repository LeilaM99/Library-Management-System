package com.github.LeilaM99.Librarary.Managment.System.service;

import com.github.LeilaM99.Librarary.Managment.System.dAO.LibraryStorage;
import com.github.LeilaM99.Librarary.Managment.System.dS.LinkedList;
import com.github.LeilaM99.Librarary.Managment.System.dS.Node;
import com.github.LeilaM99.Librarary.Managment.System.entity.Book;
import com.github.LeilaM99.Librarary.Managment.System.entity.Gender;
import com.github.LeilaM99.Librarary.Managment.System.entity.User;

public class Library {
    public LinkedList<Book> books;
    public LinkedList<User> users;

    public Library() {
        books = LibraryStorage.loadBooks();
        users = LibraryStorage.loadUsers();
    }

    public void addBook(Book book) {
        books.add(book);
        LibraryStorage.saveBooks(books);
    }

    public void removeBook(Book book) {
        books.remove(book);
        LibraryStorage.saveBooks(books);
    }

    public void updateBook(Book oldBook, String newTitle, String newAuthor) {
        Book book = books.search(oldBook);
        if (book != null) {
            book.updateBook(newTitle, newAuthor);
            LibraryStorage.saveBooks(books);
        }
    }

    public void addUser(User user) {
        users.add(user);
        LibraryStorage.saveUsers(users);
    }

    public void removeUser(User user) {
        users.remove(user);
        LibraryStorage.saveUsers(users);
    }

    public void updateUser(User oldUser, String newName, Gender newGender) {
        User user = users.search(oldUser);
        if (user != null) {
            user.updateUser(newName, newGender);
            LibraryStorage.saveUsers(users);
        }
    }

    public void borrowBook(User user, Book book) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            LibraryStorage.saveBooks(books);
            System.out.println(user.getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("The book is already borrowed.");
        }
    }

    public void returnBook(User user, Book book) {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            LibraryStorage.saveBooks(books);
            System.out.println(user.getName() + " returned: " + book.getTitle());
        } else {
            System.out.println("The book was not borrowed.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        Node<Book> temp = books.head;
        while (temp != null) {
            if (!temp.data.isBorrowed()) {
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books:");
        Node<Book> temp = books.head;
        while (temp != null) {
            if (temp.data.isBorrowed()) {
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    public void displayUsers() {
        System.out.println("Users:");
        users.display();
    }
}
