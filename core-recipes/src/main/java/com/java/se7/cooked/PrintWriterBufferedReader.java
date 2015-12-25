package com.java.se7.cooked;

import java.io.*;

class PrintWriterBufferedReader
{
	public static void main(String[] args)
	{
		try
		{
			/* prior to Java 5, PrintWriter did not have constructors that took either a string or a file.
			   So, in java 1.4 to use PrintWriter u have to go through these three lines. For Writing:  File --> FileWriter --> PrintWriter
																						
			   File file = new File("PrintWriterBufferedReader.txt");
			   FileWriter fw = new FileWriter(file);
			   PrintWriter pw = new PrintWriter(fw);
			*/
			
			/* But as Java 5, these two lines are required only. For Writing:  File --> PrintWriter
			But For Reading, u have to follow the sequence:  File --> FileReader --> BufferedReader
			*/
			File file = new File("PrintWriterBufferedReader.txt");
			PrintWriter pw = new PrintWriter(file);
			
			pw.println("howdy");
			pw.println("folks");
			pw.flush();
			pw.close();
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String data;
			while((data=br.readLine())!=null)
			{
				System.out.println(data);
			}
			pw.close();
		}
		catch(IOException e) {}
	}
}
