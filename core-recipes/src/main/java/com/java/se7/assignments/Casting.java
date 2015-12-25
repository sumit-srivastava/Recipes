package com.java.se7.assignments;

class Casting {
	public static void main(String[] args) {
		float a = 100.001f;
		int b = (int) a; // Explicit cast, the float could lose info. float to
							// int needs explicit cast.

		int c = 100;
		long d = c; // Implicit cast, an int value always fits in a long.

		long l = 130L; // larger than 127 ( the argest value a byte can store)
		byte e = (byte) l; // Hence Explicit cast required.

	}
}
