package com.java.se7.cooked;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileWriterReader
{
	public static void main(String[] args)			// FileWriter drawback -- while writing data, manual insertion of line separators.
	{												//						  while reading data back, put it into a char array.
		try
		{											// Because of these limitations, use higher level I/O classes like BufferedWriter or BufferedReader.
			char[] in = new char[50];
			int size = 0;
													// two ways to create new file--
			File file = new File("Writer.txt");  	// 1. Invoke the createNewFile()
			FileWriter fw = new FileWriter(file);	// 2. Create a Writer or a Stream, specifically a FileWriter, a PrintWriter or a FileOutputStream.
			fw.write("howdy\nfolks\n");				//    Whenever u create an instance of one of these classes, u automatically create a file.
			fw.flush();
			fw.close();
			
			FileReader fr = new FileReader(file);
			size = fr.read(in); // the read() read the whole file, one character at a time and put it into the char[] in, returns the number of character read.
			System.out.print(size + "");
			for(char c : in)
			{
				System.out.print(c);
			}
			fr.close();
		}
		catch(IOException e) {}
	}
}
