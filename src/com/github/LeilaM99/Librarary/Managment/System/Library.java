package com.github.LeilaM99.Librarary.Managment.System;

public class Library {
    private Book[] books;
    private Member[] members;
    private int bookCount;
    private int memberCount;


    public Library(int bookCapacity, int memberCapacity) {
        books = new Book[bookCapacity];
        members = new Member[memberCapacity];
        bookCount = 0;
        memberCount = 0;
    }

    public Library() {

    }

    public void addBook(Book book) {

    }

    public void editBook(int index, Book newBook) {
        if (index >= 0 && index < bookCount) {
            books[index] = newBook;
        } else {
            System.out.println("Invalid book index.");
        }
    }

    public void removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                books[i] = books[bookCount - 1];
                books[bookCount - 1] = null;
                bookCount--;
                System.out.println("Book removed: " + title);
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }


    public void displayBooks() {
        for (int i = 0; i < bookCount; i++) {
            books[i].displayInfo();
        }
    }


    public void addMember(Member member) {
        if (memberCount < members.length) {
            members[memberCount] = member;
            memberCount++;
        } else {
            System.out.println("Member list is full! Cannot add more members.");
        }
    }

    public void editMember(int index, Member newMember) {
        if (index >= 0 && index < memberCount) {
            members[index] = newMember;
        } else {
            System.out.println("Invalid member index.");
        }
    }

    public void displayMembers() {
        for (int i = 0; i < memberCount; i++) {
            members[i].displayInfo();
        }
    }

    public void checkOutBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title) && !books[i].isCheckedOut()) {
                books[i].checkOut();
                System.out.println("You have checked out: " + title);
                return;
            }
        }
        System.out.println("Book not available for checkout.");
    }

    public void returnBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title) && books[i].isCheckedOut()) {
                books[i].returnBook();
                System.out.println("You have returned: " + title);
                return;
            }
        }
        System.out.println("This book was not checked out.");
    }

}
