package com.github.LeilaM99.Librarary.Managment.System.dAO;

import com.github.LeilaM99.Librarary.Managment.System.dS.LinkedList;
import com.github.LeilaM99.Librarary.Managment.System.entity.User;

import java.io.*;

public class UserStorage extends Storage<User> {

    public UserStorage() {

        super("users.ser");
    }

    public void save(LinkedList<User> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.err.println("Error saving data to " + fileName + ": " + e.getMessage());
        }
    }

    public LinkedList<User> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (LinkedList<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data from " + fileName + ": " + e.getMessage());
            return new LinkedList<>();
        }
    }
}
}