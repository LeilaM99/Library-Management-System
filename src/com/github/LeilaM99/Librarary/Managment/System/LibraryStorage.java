package com.github.LeilaM99.Librarary.Managment.System;

import java.util.*;
import java.io.*;

public class LibraryStorage {

        private static final String BOOK_FILE = "books.txt";
        private static final String USER_FILE = "users.txt";

        public static void saveBooks(LinkedList<Book> books) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(BOOK_FILE))) {
                Node<Book> current = books.head;
                while (current != null) {
                    Book b = current.data;
                    writer.println(b.getTitle() + ";" + b.getAuthor() + ";" + b.isBorrowed());
                    current = current.next;
                }
            } catch (IOException e) {
                System.err.println("Error saving books: " + e.getMessage());
            }
        }

        public static void saveUsers(LinkedList<User> users) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE))) {
                Node<User> current = users.head;
                while (current != null) {
                    User u = current.data;
                    writer.println(u.getName() + ";" + u.getUserId() + ";" + u.getGender());
                    current = current.next;
                }
            } catch (IOException e) {
                System.err.println("Error saving users: " + e.getMessage());
            }
        }

        public static LinkedList<Book> loadBooks() {
            LinkedList<Book> books = new LinkedList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(BOOK_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    Book book = new Book(parts[0], parts[1]);
                    book.setBorrowed(Boolean.parseBoolean(parts[2]));
                    books.add(book);
                }
            } catch (IOException e) {
                System.err.println("Error loading books: " + e.getMessage());
            }
            return books;
        }

        public static LinkedList<User> loadUsers() {
            LinkedList<User> users = new LinkedList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    User user = new User(parts[0], Integer.parseInt(parts[1]), Gender.valueOf(parts[2]));
                    users.add(user);
                }
            } catch (IOException e) {
                System.err.println("Error loading users: " + e.getMessage());
            }
            return users;
        }


}
