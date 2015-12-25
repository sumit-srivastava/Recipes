package com.java.se7.cooked;

import java.io.File;
import java.io.IOException;

class CreateNewFile
{
	public static void main(String[] args)
	{
		try
		{
			boolean newFile = false;
			
			File file = new File("Writer1.txt");
			System.out.println(file.exists());
						
			newFile = file.createNewFile();
			System.out.println(newFile);
			System.out.println(file.exists());
		}
		catch(IOException e) {}
	}
}
			
