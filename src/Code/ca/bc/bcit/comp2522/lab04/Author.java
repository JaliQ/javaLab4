package ca.bc.bcit.comp2522.lab04;
/**
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class Author extends Person{
        final private String Genre;

    /**
     * constructor of Author class
     * @param Genre Genre of the author as a string
     * @param name Name of author as Name class
     * @param dateBorn date of birth of author
     * @param dateDied date died of author
     */
    public Author(String Genre, Name name,Date dateBorn, Date dateDied) {
        super(name, dateBorn, dateDied);
        this.Genre = Genre;
    }

    /**
     * display function from printable
     */
    @Override
    public void display(){
        super.display();
        System.out.println("Genre: " + Genre);
    }
}
