package com.java.se7.collection.recipes.WhyComparator;

import java.util.Comparator;

class GenreSort implements Comparator<DVDInfo>
{
	public int compare(DVDInfo one, DVDInfo two)
	{
		return one.getGenre().compareTo(two.getGenre());
	}
}
