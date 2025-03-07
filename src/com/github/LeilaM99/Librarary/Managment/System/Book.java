package com.github.LeilaM99.Librarary.Managment.System;

public class Book {

        private String title;
        private String author;
        private String isbn;
        private boolean isCheckedOut;

        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.isCheckedOut = false;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getIsbn() {
            return isbn;
        }

        public boolean isCheckedOut() {
        return isCheckedOut;
        }

         public void checkOut() {
        isCheckedOut = true;
         }

         public void returnBook() {
         isCheckedOut = false;
         }

        public void displayInfo() {
            System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
        }

}
