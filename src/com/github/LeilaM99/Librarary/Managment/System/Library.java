package com.github.LeilaM99.Librarary.Managment.System;
import java.util.ArrayList;
import java.util.List;

public class Library {

        private List<Book> books;
        private List<Member> members;

        public Library() {
            books = new ArrayList<>();
            members = new ArrayList<>();
        }

        // متد برای اضافه کردن کتاب
        public void addBook(Book book) {
            books.add(book);
        }

        // متد برای ویرایش اطلاعات کتاب
        public void editBook(String isbn, String newTitle, String newAuthor) {
            for (Book book : books) {
                if (book.getIsbn().equals(isbn)) {
                    book.setTitle(newTitle);
                    book.setAuthor(newAuthor);
                    break;
                }
            }
        }

        // متد برای ثبت عضو جدید
        public void addMember(Member member) {
            members.add(member);
        }

        // متد برای امانت کتاب
        public boolean borrowBook(String isbn, Member member) {
            for (Book book : books) {
                if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                    book.setAvailable(false);
                    return true; // امانت با موفقیت انجام شد
                }
            }
            return false; // کتاب در دسترس نیست
        }

        // متد برای عودت کتاب
        public boolean returnBook(String isbn) {
            for (Book book : books) {
                if (book.getIsbn().equals(isbn)) {
                    book.setAvailable(true);
                    return true; // عودت با موفقیت انجام شد
                }
            }
            return false; // کتاب یافت نشد
        }

        public List<Member> getMembers() {
        return members;
        }
}
