package com.java.se7.enums.recipes.type2;

import java.util.Calendar;

/**
 * A programmer can specify values of enum constants at their creation time.
 * However, in order for this approach to function properly, a private member variable and a private constructor must be defined.
 * In order to retrieve the value of each constant of the enum, you can define a public method inside the enum.
 */
public enum Day {
    SUNDAY(1),
	MONDAY(2),
	TUESDAY(3),
	WEDNESDAY(4),
	THURSDAY(5),
	FRIDAY(6),
	SATURDAY(7);

    private int value;

    private Day(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        Calendar date = Calendar.getInstance();
        switch(this) {
            case FRIDAY:
                return "Friday: " + value;
            case MONDAY:
                return "Monday: " + value;
            case SATURDAY:
                return "Saturday: " + value;
            case SUNDAY:
                return "Sunday: " + value;
            case THURSDAY:
                return "Thursday: " + value;
            case TUESDAY:
                return "Tuesday: " + value;
            case WEDNESDAY:
                return "Wednesday: " + value;
            default:
                return null;
        }
    }
}
