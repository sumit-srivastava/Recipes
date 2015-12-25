package com.java.se7.collection.recipes.WhyComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vf-root on 2/13/15.
 */
public class MainClass {

    public static void main(String[] args){
        Person person1 = new Person();
        person1.setAddress("ABC");
//        person1.setId(1);
        person1.setName("Niv");

        Person person2 = new Person();
        person2.setAddress("XYZ");
        person2.setId(2);
        person2.setName("Alex");


        Person person3 = new Person();
        person3.setAddress("PQR");
        person3.setId(3);
        person3.setName("Mida");

        List<Person> personList = new ArrayList<Person>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

//        Comparator<Person> cp = PersonComparator.getComparator(PersonComparator.SortParameter.ID_ASCENDING,PersonComparator.SortParameter.NAME_ASCENDING);
        Comparator<Person> cp = PersonComparator.getComparator(PersonComparator.SortParameter.NAME_ASCENDING,PersonComparator.SortParameter.ID_ASCENDING);
        Collections.sort(personList, cp);

        for (Person person: personList){
            System.out.println(person.getName());
        }
    }
}
