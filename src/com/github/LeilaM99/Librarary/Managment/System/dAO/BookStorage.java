package com.github.LeilaM99.Librarary.Managment.System.dAO;

import com.github.LeilaM99.Librarary.Managment.System.dS.LinkedList;
import com.github.LeilaM99.Librarary.Managment.System.entity.Book;

import java.io.*;

public class BookStorage extends Storage<Book> {

    public BookStorage() {

        super("books.ser");
    }

    @Override
    public void save(LinkedList<Book> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.err.println("Error saving data to " + fileName + ": " + e.getMessage());
        }
    }

    public LinkedList<Book> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (LinkedList<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data from " + fileName + ": " + e.getMessage());
            return new LinkedList<>();
        }
    }
}
}