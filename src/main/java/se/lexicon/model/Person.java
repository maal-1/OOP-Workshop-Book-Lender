package se.lexicon.model;

import java.util.Arrays;

/**
 * This class represents a Person model with properties and methods
 * to manage personal details and interactions with the library system.
 */
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private static int sequencer = 1;
    private Book[] borrowedBooks = new Book[0];

    public Person(String firstName, String lastName) {
        id = getNextId();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private static int getNextId () {
        return sequencer++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean loanBook (Book book) {
        for (Book b : borrowedBooks) {
            if (b.getId() == book.getId())
                return true;
        }

        if (book.borrow(this)) {
            Book [] newBooks = new Book[borrowedBooks.length+1];
            for (int i = 0; i < borrowedBooks.length; i++) {
                newBooks[i] = borrowedBooks[i];
            }
            newBooks[borrowedBooks.length] = book;
            borrowedBooks = newBooks;

            return true;
        }

        return false;
    }

    public void returnBook (Book book) {
        for (Book b : borrowedBooks) {
            for (int i = 0; i < borrowedBooks.length; i++) {
                if (borrowedBooks[i].getId() == book.getId()){
                    book.returnBook();
                    borrowedBooks[i] = null;
                }
            }

                Book [] newBooks = new Book[borrowedBooks.length-1];
                int j = 0;
                for (int i = 0; i < borrowedBooks.length; i++) {
                    if (borrowedBooks[i] == null){
                        continue;
                    }
                    newBooks[j] = borrowedBooks[i];
                    j++;
                }
                borrowedBooks = newBooks;



        }
    }

    public String getPersonInformation (){
        return "Name:" + getFirstName() + " " + getLastName() + ", ID: " + getId();
    }

    public int getId() {
        return id;
    }

    public String getBorrowedBooksInfo(){
        StringBuilder borrowedBooksInfo = new StringBuilder();
        for (Book borrowedBook : borrowedBooks) {
            borrowedBooksInfo.append(borrowedBook.getBookInformation()).append(", \n");
        }

        return borrowedBooksInfo.toString();
    }
}