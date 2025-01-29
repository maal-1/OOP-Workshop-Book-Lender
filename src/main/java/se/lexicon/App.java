package se.lexicon;


import se.lexicon.model.*;

public class App {
    public static void main(String[] args) {

        Book book1 = new Book("The flowers", "Mike Baker");
        Person adam = new Person("Adam", "Smith");
        System.out.println(adam.loanBook(book1));
        System.out.println(adam.getPersonInformation());
        System.out.println(adam.getBorrowedBooksInfo());

        Book book2 = new Book("The Day", "Mike Baker");

        System.out.println(adam.loanBook(book2));
        System.out.println(adam.getBorrowedBooksInfo());

        adam.returnBook(book2);
        System.out.println(adam.getBorrowedBooksInfo());


    }

}
