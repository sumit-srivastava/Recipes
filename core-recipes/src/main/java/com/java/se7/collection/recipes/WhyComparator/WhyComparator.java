package com.java.se7.collection.recipes.WhyComparator;

import java.io.*;
import java.util.*;

public class WhyComparator									//1. gives u the capability to sort a given collection any number of diff. ways						
{															//   while comparable only in sigle i.e. natural order.					
    ArrayList<DVDInfo> dList = new ArrayList<DVDInfo>();    //2. It is applicable to those classes also which cannot be modified
	//DVDInfo[] dArr = new DVDInfo[100];					//   while in comparable the class object to be sorted must implement it.
	public static void main(String[] args)
	{
		new WhyComparator().populateList();
		
	}
	
	public void populateList()
	{
		try
		{
			File file = new File("dvdInfo.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String s, del = "/";
			int i = 0;
			String[] str = new String[500];
			while((s = br.readLine())!=null)
			{
				str[i] = s;
				String[] tokens = str[i].split(del);
				//  = new DVDInfo(tokens[0], tokens[1], tokens[2]);
				//dList.add(dArr[i]);
				dList.add(new DVDInfo(tokens[0], tokens[1], tokens[2]));
				i++;
			}
			System.out.println("Without sort");
			System.out.println(dList);
			GenreSort gs = new GenreSort();
			Collections.sort(dList, gs);
			System.out.println("After sort");
			System.out.println(dList);
			
		}
		catch(IOException e) {}
	}
}
