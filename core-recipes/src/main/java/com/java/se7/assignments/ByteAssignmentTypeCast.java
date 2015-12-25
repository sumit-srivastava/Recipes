package com.java.se7.assignments;

class ByteAssignmentTypeCast
{
	public static void main(String[] args)
	{
		byte a = 3;
		byte b = 8;
		//byte c = a + b; 		Here a type cast is required bcoz add two bytes together and u'll get an int. compiler error -- possible loss of precision.
		byte c = (byte)(a + b);
		byte d = 3;
		d += 7;					// No problem - adds 7 to b ( result is 10 )
		d = (byte) (d + 7);		// won't compile without the cast, since b + 7 results an int
		System.out.println("Byte c = " + c);
	}
}

