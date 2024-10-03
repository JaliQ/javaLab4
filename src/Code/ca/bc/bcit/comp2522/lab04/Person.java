package ca.bc.bcit.comp2522.lab04;

/**
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class Person implements Comparable<Person>, Printable, Reversible {
    private final Name name;
    private final Date dateBorn;
    private final Date dateDied;

    /**
     * Constructs a ca.bc.bcit.comp2522.lab04.Person object with a name, date of birth, and optional date of death.
     *
     * @param name     the person's name
     * @param dateBorn the person's date of birth
     * @param dateDied the person's date of death (can be null if the person is still alive)
     */
    public Person(final Name name, final Date dateBorn, final Date dateDied) {
        this.name = name;
        this.dateBorn = dateBorn;
        this.dateDied = dateDied;
    }

    /**
     * Returns a string containing details about the person, including their name, status (alive or dead),
     * and the date of birth and death (if applicable).
     *
     * @return a formatted string with the person's details
     */
    public void display() {
        String status = isAlive() ? "alive" : "died"; // Determine if the person is alive or dead
        name.display();
        System.out.println(" (" + (status.equals("alive") ? status : status + " " + dateDied.getDayOfWeek()
                + ", " + dateDied.getMonth() + " " + dateBorn.getDay() + ", " + dateDied.getYear())
                + ") was born on " + dateBorn.getDayOfWeek() + ", " + dateBorn.getMonth() + " " + dateBorn.getDay()
                + ", " + dateBorn.getYyyyMmDd());
    }

    @Override
    public void backward() {
        backwards();
    }

    /**
     * Prints the name or title of the implementing object backward.
     */
    public void backwards() {
        final StringBuilder firstReversed;
        final StringBuilder lastReversed;

        firstReversed = new StringBuilder(name.getFirst()).reverse();
        lastReversed = new StringBuilder(name.getLast()).reverse();
        System.out.println(firstReversed.toString() + lastReversed.toString());
    }


    public int compareTo(Person person) {
        final int localAge = Date.MAX_YEAR - dateBorn.getYear();
        final int personAge = person.dateBorn.getYear() - dateBorn.getYear();
        return localAge - personAge;
    }

    /**
     * Checks if the person is alive (i.e., the date of death is null).
     *
     * @return true if the person is alive, false otherwise
     */
    public boolean isAlive() {
        return dateDied == null; // Returns true if the date of death is null
    }

    /**
     * Returns the person's name.
     *
     * @return the person's name
     */
    public Name getName() {
        return name;
    }

    /**
     * Returns the date the person was born.
     *
     * @return the person's date of birth
     */
    public Date getDateBorn() {
        return dateBorn;
    }

    /**
     * Returns the date the person died (null if still alive).
     *
     * @return the person's date of death
     */
    public Date getDateDied() {
        return dateDied;
    }
}
