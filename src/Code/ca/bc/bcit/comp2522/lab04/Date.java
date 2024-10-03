/**
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class Date implements Printable{
    // Constants for valid date ranges and month details
    private static final int MIN_YEAR = 1800;
    public static final int MAX_YEAR = 2024;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int FEBRUARY = 2;
    private static final int LEAP_YEAR_DAYS = 29;
    private static final int NON_LEAP_YEAR_DAYS = 28;
    private static final int DAYS_IN_WEEK = 7;
    private static final int BASE_CENTURY_YEAR = 100;
    private static final int DIVISOR_400 = 400;
    private static final int DIVISOR_100 = 100;
    private static final int DIVISOR_4 = 4;
    private static final int ZELLER_CONG_BASE = 5;
    private static final int ZELLER_CONG_MUL = 13;
    private static final int ZELLER_CONG_ADD = 12;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    // Days in each month for non-leap years
    private static final int[] DAYS_IN_MONTH = {0, 31, NON_LEAP_YEAR_DAYS, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Displays every instance variable, including those inherited
     * from parent classes, in a descriptive sentence.
     */
    @Override
    public void display() {
        System.out.println("The year is" + year + "the month is" + month + "the day is" + day);
    }

    // Enum representing days of the week
    private enum DAYSOFWEEK {Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday};

    // Array of month names
    private static final String[] MONTHS = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};

    private final int year;  // Year of the date
    private final int month; // Month of the date (1-12)
    private final int day;   // Day of the date (1-31)

    /**
     * Constructs a new Date object.
     *
     * @param year  the year
     * @param month the month (1-12)
     * @param day   the day of the month (1-31)
     * @throws IllegalArgumentException if the date is invalid
     */
    public Date(final int year, final int month, final int day) {
        validateDate(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Validates the provided year, month, and day to ensure a valid date.
     *
     * @param year  the year
     * @param month the month (1-12)
     * @param day   the day of the month (1-31)
     * @throws IllegalArgumentException if the date is invalid
     */
    private void validateDate(final int year, final int month, final int day) {
        if (year < MIN_YEAR || year > MAX_YEAR) {
            throwDateException(year, month, day);
        }

        if (month < MIN_MONTH || month > MAX_MONTH) {
            throwDateException(year, month, day);
        }

        if (day < MIN_DAY || day > getDaysInMonth(year, month)) {
            throwDateException(year, month, day);
        }
    }

    /**
     * Gets the day of the month.
     *
     * @return the day of the month
     */
    public int getDay() {
        return day;
    }

    /**
     * Gets the month.
     *
     * @return the name of the month
     */
    public String getMonth() {
        return MONTHS[month - ONE];
    }

    /**
     * Gets the year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Throws an IllegalArgumentException for an invalid date.
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     * @throws IllegalArgumentException if Date doesn't meet conditions
     */
    public void throwDateException(final int year, final int month, final int day) {
        throw new IllegalArgumentException("Invalid date: " + year + "-" + month + "-" + day);
    }

    /**
     * Gets the date in YYYY-MM-DD format.
     *
     * @return the date in YYYY-MM-DD format
     */
    public String getYyyyMmDd() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * Gets the day of the week from enum DAYSOFWEEK.
     * Based on the number of the month grabs the month with the same index-1, since
     * indexes star with 0 and month with 1.
     *
     * @return the day of the week (0-6, where 0 is Sunday)
     */
    public DAYSOFWEEK getDayOfWeek() {
        int yearCopy;
        int monthCopy;
        int dayCopy;
        monthCopy = month;
        yearCopy  = year;

        // Adjust year and month for calculation if month is January or February
        if (monthCopy <= FEBRUARY) {
            yearCopy--;
            monthCopy += ZELLER_CONG_ADD;
        }

        dayCopy = day;
        int century = yearCopy / BASE_CENTURY_YEAR;
        yearCopy %= BASE_CENTURY_YEAR;

        // Zeller's Congruence algorithm to calculate day of the week
        int w = (dayCopy + (ZELLER_CONG_MUL * (monthCopy + ONE)) / ZELLER_CONG_BASE + yearCopy +
                yearCopy / DIVISOR_4 + century / DIVISOR_4 + ZELLER_CONG_BASE * century) % DAYS_IN_WEEK;
        return DAYSOFWEEK.values()[w];
    }

    /**
     * Gets the number of days in a given month.
     *
     * @param year  the year
     * @param month the month (1-12)
     * @return the number of days in the month
     */
    private static int getDaysInMonth(final int year, final int month) {
        if (month == FEBRUARY) {
            return isLeapYear(year) ? LEAP_YEAR_DAYS : NON_LEAP_YEAR_DAYS;
        } else {
            return DAYS_IN_MONTH[month];
        }
    }

    /**
     * Checks if a given year is a leap year.
     *
     * @param year the year
     * @return true if it is a leap year, false otherwise
     */
    private static boolean isLeapYear(final int year) {
        return (year % DIVISOR_4 == ZERO && year % DIVISOR_100 != ZERO) || (year % DIVISOR_400 == ZERO);
    }
}
