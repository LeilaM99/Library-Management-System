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

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    public void editBook(int index, Book newBook) {
        if (index >= 0 && index < bookCount) {
            books[index] = newBook;
        } else {
            System.out.println("Invalid book index.");
        }
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

}
