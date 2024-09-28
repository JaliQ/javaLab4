/**
 * Name class
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class Name  implements Printable{
    private final String first;
    private final String last;

    private static final int MAX_LENGTH = 50;
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 1;

    /**
     * Constructs a new Name object.
     *
     * @param first the first name
     * @param last the last name
     * @throws IllegalArgumentException if either name is null, blank, contains "admin" (in any casing), or is longer than 45 characters
     */
    public Name(final String first, final String last) {
        validateName(first, "First name");
        validateName(last, "Last name");

        this.first = first;
        this.last = last;
    }

    /**
     * Validates the provided name to ensure it meets the requirements.
     *
     * @param name the name to be validated
     * @param nameType the type of name (e.g., "First name", "Last name") for error message clarity
     * @throws IllegalArgumentException if the name is invalid
     */
    private void validateName(final String name, final String nameType) {
        if (name == null ||
                name.isBlank() ||
                name.contains("admin") ||
                name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Invalid " + nameType + ": " + name);
        }
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirst() {
        return first;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLast() {
        return last;
    }

    /**
     * Displays every instance variable, including those inherited
     * from parent classes, in a descriptive sentence.
     */
    @Override
    public void display() {
        System.out.println(first + " " + last);
    }
}
