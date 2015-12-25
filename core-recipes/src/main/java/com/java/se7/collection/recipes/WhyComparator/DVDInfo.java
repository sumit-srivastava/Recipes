package com.java.se7.collection.recipes.WhyComparator;

/**
 * Created by vf-root on 2/13/15.
 */
public class DVDInfo
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
	public String getTitle()
	{
		return title;
	}
	public String getGenre()
	{
		return genre;
	}
	
		
}
