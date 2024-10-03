package ca.bc.bcit.comp2522.lab04;

/**
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class Book implements Comparable<Book>, Printable, Reversible {

    private String title;
    private int yearPublished;
    private Author author;
    private final int CURR_YEAR = 2024;
    private final int TITLE_MIN = 1;
    private final int TITLE_MAX = 100;
    private final String ERROR_MESSAGE = "Invalid book details";
    public Book(String title,
                int yearPublished,
                Author author)
    {
        checkBook(title, yearPublished, author);
        this.title = title;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    private void checkBook(String title,
                           int yearPublished,
                           Author author){
        if (title == null ||
                title.isBlank() ||
                title.length() > TITLE_MAX ||
                yearPublished < TITLE_MIN ||
                yearPublished > CURR_YEAR)
        {
            throw new IllegalArgumentException("Invalid book details");
        }

    }
    @Override
    public int compareTo(Book other)
    {
        return Integer.compare(this.yearPublished, other.yearPublished); // Older books are "larger"
    }

    @Override
    public void display()
    {
        System.out.println("Title: " + title);
        System.out.println("Year Published: " + yearPublished);
        author.display(); // Display author details
    }

    @Override
    public void backward() {
        System.out.println(new StringBuilder(title).reverse().toString());
    }

    @Override
    public void backwards() {
        backward();
    }


}