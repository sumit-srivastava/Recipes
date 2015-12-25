package com.java.se7.enums.recipes;

import com.java.se7.enums.recipes.type2.Day;
import com.java.se7.enums.recipes.type3.Car;
import com.java.se7.enums.recipes.type4.Currency;

/**
 * The values inside an enum are constants and thus, you can use them in comparisons using the equals or compareTo methods.
 * The Java Compiler automatically generates a static method for each enum, called values.
 * This method returns an array of all constants defined inside the enum.
 * The values are returned in the same order as they were initially defined
 *
 * An enum contains the name and valueOf methods.
 * The valueOf method can be used to map from a name to the corresponding enum constant,
 * while the name method returns the name of an enum’s constant, exactly as declared in its declaration.
 * Also, an enum can override the toString method, just like any other Java class.
 *
 * name --> constant itself as string
 * valueOf --> get enum constant from a string, throws IllegalArgumentException if string is not matching any of the constants.
 * values() --> list of enum constants.
 */
public class MainClass {
	public static void main(String[] args) {
		System.out.println("FRIDAY".compareTo(Day.FRIDAY.name()) + "\n");
		
		for(Day day: Day.values()) {
            System.out.println(day.name());
            System.out.println(day.getValue());
            System.out.println(day);
        }

		
		System.out.println();
		
		//The following statements are illegal.
		//Day d = new Day();
		//Day.FRIDAY = Day.valueOf("New Value");
		
		Car c = Car.AUDI;
		System.out.println(c.name() + ": " + c.getPrice());
		
		Car c1 = Car.valueOf("MERCEDES2");
		System.out.println(c1.toString());
		
		//The following statement throws an java.lang.IllegalArgumentException.
		//Car c2 = Car.valueOf("Bmw");

        Currency currency = Currency.DIME;
        Day day = Day.MONDAY;
        System.out.println("Color: " + Currency.DIME.color());
        System.out.println("Color: " + currency.color());
        if (day == Day.MONDAY){
            System.out.println("Monday");
        }

        String str = "com.vodafone.global.netflix.opco.properties-DEFAULT.cfg";
        System.out.println(str.contains("DEFAULT"));

        System.out.println(System.getProperty("abs"));

	}
}
