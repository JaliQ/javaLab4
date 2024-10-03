package ca.bc.bcit.comp2522.lab04;

/**
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class Autobiography extends Biography {
    public Autobiography(String title, int yearPublished, Author author) {
        super(title, yearPublished, author, author); // Subject is automatically the author
    }

    @Override
    public void display() {
        super.display();
        System.out.println("This is an autobiography.");
    }
}