package ca.bc.bcit.comp2522.lab04;

/**
 * The ca.bc.bcit.comp2522.lab04.Printable interface defines a contract for displaying
 * all instance variables of an implementing class in a sentence.
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
interface Printable {
    /**
     * Displays every instance variable, including those inherited
     * from parent classes, in a descriptive sentence.
     */
    void display();
}
