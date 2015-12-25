package com.java.se7.collection.recipes.WhyIterator;

import java.util.*;

class Dog {
	public String name;

	Dog(String n) {
		name = n;
	}
}

// most common way to examine a List "element by element" before Java5, and the
// enhanced for loop.
class WhyIterator {
	public static void main(String[] args) {
		List<Dog> d = new ArrayList<Dog>();
		Dog dog = new Dog("aiko");
		d.add(dog);
		d.add(new Dog("clover"));
		d.add(new Dog("magnolia"));
		Iterator<Dog> i3 = d.iterator(); // notice 'i',iterator is having
											// generic syntax with Dog
											// specified, w/o generic -->
											// Iterator i3 = d.iterator();
		while (i3.hasNext()) // returns true if there is at least one more
								// element in the collection.
		{
			Dog d2 = i3.next(); // cast not required. if not generic then -->
								// Dog d2 = (Dog)i3.next();
			System.out.println(d2.name);
		}
		System.out.println("size " + d.size());
		System.out.println("get1 " + d.get(1).name);
		System.out.println("aiko " + d.indexOf(dog));
		d.remove(2);
		Object[] oa = d.toArray();
		for (Object o : oa) {
			Dog d2 = (Dog) o;
			System.out.println("oa " + d2.name);
		}
	}
}
