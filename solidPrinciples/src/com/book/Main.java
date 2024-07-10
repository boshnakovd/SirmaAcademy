package com.book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("300", "Sparta", 1998);
        bookRepo bookRepo = new bookRepo();
        bookRepo.saveToDatabase(book);
    }
}
