package se.lexicon.model;


import java.util.UUID;

/**
 * This class represents a Book model with properties and methods
 * to manage book-related information and operations.
 */
public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person borrower;

    public Book (String title, String author) {
        id = UUID.randomUUID().toString();
        available = true;
        this.title = title;
        this.author = author;
    }

    public Book (String title, String author, Person borrower) {
        this(title, author);
        this.borrower = borrower;
        available = false;
    }

    public String getId() {
        return id;
    }

    public boolean borrow (Person borrower) {
        if (available) {
            this.borrower = borrower;
            available = false;
            return true;
        }
        return false;
    }

    public void returnBook () {
        this.borrower = null;
        available = true;
    }

    public String getBookInformation (){
        return "Title: " + title + ", Author: " + author + ", ID: " + id + ", Available: " + available;
    }


}