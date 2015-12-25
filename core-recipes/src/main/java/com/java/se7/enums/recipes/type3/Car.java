package com.java.se7.enums.recipes.type3;

/**
 * you can define abstract methods inside an enum in Java.
 * Each constant of the enum implements each abstract method independently.
 *
 * An enum in Java can implement an Interface or extend a class, just like any other normal class.
 * Also, an enum implicitly implements both the Serializable and Comparable interfaces.
 */
public enum Car {
	AUDI {
		@Override
		public int getPrice() {
			return 25000;
		}
	},
	MERCEDES {
		@Override
		public int getPrice() {
			return 30000;
		}
	},
	BMW {
		@Override
		public int getPrice() {
			return 20000;
		}
	};
	
	public abstract int getPrice();
}
