package ca.bc.bcit.comp2522.lab04;

/**
 * The ca.bc.bcit.comp2522.lab04.Reversible interface defines a contract for reversing
 * and printing the name or title of an object.
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
interface Reversible {
    void backward();

    /**
     * Prints the name or title of the implementing object backward.
     */
    void backwards();
}
