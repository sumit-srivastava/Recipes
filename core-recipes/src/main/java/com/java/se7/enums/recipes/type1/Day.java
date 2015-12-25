package com.java.se7.enums.recipes.type1;

/**
 * You should use an enum, when you need to define and represent a fixed set of constants.
 * The values defined inside an enum are constants and shall be typed in uppercase letters.
 * These values are implicitly static and final and cannot be changed, after their declaration.
 * Enums in Java are type-safe and thus, the value of an enum variable must be one of the predefined values of the enum itself.
 * Also, enums have their own namespace and they can be used in a switch statement, in the same way as integers.
 * enums in Java are considered to be reference types, like class or Interface and thus, a programmer can define constructor,
 * methods and variables, inside an enum.
 *
 *
 */
public enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}
