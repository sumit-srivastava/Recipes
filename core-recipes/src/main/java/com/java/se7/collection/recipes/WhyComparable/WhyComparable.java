package com.java.se7.collection.recipes.WhyComparable;

import java.io.*;
import java.util.*;

class DVDInfo implements Comparable<DVDInfo>
{
	String title;
	String genre;
	String leadActor;
	DVDInfo() {}
	DVDInfo(String t, String g, String a)
	{
		title = t;
		genre = g;
		leadActor = a;
	}
	public String toString()
	{
		return title + " " + genre + " " + leadActor + "\n";
	}
	public int compareTo(DVDInfo d)
	{
		return title.compareTo(d.getTitle());
	}
	public String getTitle()
	{
		return title;
	}
		
}
class WhyComparable
{
	ArrayList<DVDInfo> dList = new ArrayList<DVDInfo>();
	//DVDInfo[] dArr = new DVDInfo[100];
	public static void main(String[] args)
	{
		new WhyComparable().populateList();
		
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
			Collections.sort(dList);
			System.out.println(dList);
			
		}
		catch(IOException e) {}
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
