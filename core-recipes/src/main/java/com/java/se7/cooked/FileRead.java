package com.java.se7.cooked;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class FileRead
{
   public static void main(String args[])
  {
      try{
    // Open the file that is the first 
    // command line parameter
    FileInputStream fstream = new FileInputStream("c:/java/textfile.txt");
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   {
      // Print the content on the console
      System.out.println (strLine);
    }
    //Close the input stream
    in.close();
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }
}


/* 
From any text file reading data through FileInputStream

FileInputStream --> DataInputStream --> InputStreamReader --> BufferedReader

*/
