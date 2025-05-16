package com.github.LeilaM99.Librarary.Managment.System.entity;
import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int userId;
    private Gender gender;

    public User(String name, int userId, Gender gender) {
        this.name = name;
        this.userId = userId;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public Gender getGender() {
        return gender;
    }

    public void updateUser(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", User ID: " + userId + ", Gender: " + gender;
    }
}
