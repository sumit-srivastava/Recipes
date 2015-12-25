package com.java.se7.collection.recipes.WhyMaps;

import java.util.*;

class Dog {
	public Dog(String n) {
		name = n;
	}

	public String name;

	public boolean equals(Object o) // just define it, need not to call, will be
									// called by Map automatically.
	{
		if ((o instanceof Dog) && (((Dog) o).name == name)) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() // just define it, need not to call, will be called by
							// Map automatically.
	{
		return name.length();
	}
}

class Cat {
}

enum Pets {
	DOG, CAT, HORSE
} // enums can be used as key successfully bcoz enums override equals() and
	// hashCode().

// while using Map, must override the hashCode() and equals() in the classes
// being used as part of the keys for that Map, otherwise you wont get your
// stuff.
class WhyMaps {
	public static void main(String[] args) {
		Map<Object, Object> m = new HashMap<Object, Object>();

		m.put("k1", new Dog("aiko"));
		m.put("k2", Pets.DOG); // for enum it will simply print the enum
								// variable.
		m.put(Pets.CAT, "CAT key");
		Dog d1 = new Dog("clover");
		m.put(d1, "Dog key");
		m.put(new Cat(), "CAT key");

		System.out.println(m.get("k1"));
		String k2 = "k2";
		System.out.println(m.get("k2"));
		Pets p = Pets.CAT;
		System.out.println(m.get(p));
		System.out.println(m.get(d1));
		System.out.println(m.get(new Cat())); // since Cat class has no t
												// overridden hashCode() and
												// equals(), u'll get null in
												// place of ur stuff.
		System.out.println(m.size());

		// now what happens when an object used as a key has its values changed?
		d1.name = "magnolia"; // notice Dog.name variable is used to create the
								// hashCode()
		System.out.println(m.get(d1)); // null

		d1.name = "clover"; // hashCode() value same and equals() returns true
		System.out.println(m.get(new Dog("clover")));

		d1.name = "arthur";
		System.out.println(m.get(new Dog("clover"))); // hashCode() value same
														// but not equal() to
														// "clover", returns
														// null.

	}
}
