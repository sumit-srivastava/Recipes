package com.java.se7.concurrency.recipes.thread.management.creating.threads.through.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Theory:
 *
 * The factory pattern is one of the most used design patterns in the object-oriented
 * programming world. It is a creational pattern and its objective is to develop an object whose
 * mission will be creating other objects of one or several classes. Then, when we want to create
 * an object of one of those classes, we use the factory instead of using the new operator.
 *
 * With this factory, we centralize the creation of objects with some advantages:
 * It's easy to change the class of the objects created or the way we create these objects.
 * It's easy to limit the creation of objects for limited resources. For example,
 * we can only have n objects of a type.
 *
 * It's easy to generate statistical data about the creation of the objects.
 * Java provides an interface, the ThreadFactory interface to implement a Thread
 * object factory. Some advanced utilities of the Java concurrency API use thread factories
 * to create threads.
 *
 * How it works:
 *
 * The ThreadFactory interface has only one method called newThread. It receives a
 * Runnable object as a parameter and returns a Thread object. When you implement a
 * ThreadFactory interface, you have to implement that interface and override this method.
 * Most basic ThreadFactory, has only one line.
 *      return new Thread(r);
 *
 * You can improve this implementation by adding some variants by:
 *  --> Creating personalized threads, as in the example, using a special format for the name
 *       or even creating our own thread class that inherits the Java Thread class
 *  --> Saving thread creation statistics, as shown in the previous example
 *  --> Limiting the number of threads created
 *  --> Validating the creation of the threads
 *  --> And anything more you can imagine
 *
 *
 *
 * Class that implements the ThreadFactory interface to
 * create a basic thread factory
 *
 */
public class MyThreadFactory implements ThreadFactory {

	// Attributes to save the necessary data to the factory
	private int counter;
	private String name;
	private List<String> stats;
	
	/**
	 * Constructor of the class
	 * @param name Base name of the Thread objects created by this Factory
	 */
	public MyThreadFactory(String name){
		counter=0;
		this.name=name;
		stats=new ArrayList<String>();
	}
	
	/**
	 * Method that creates a new Thread object using a Runnable object
	 * @param r: Runnable object to create the new Thread
	 */
	@Override
	public Thread newThread(Runnable r) {
		// Create the new Thread object
		Thread t=new Thread(r,name+"-Thread_"+counter);
		counter++;
		// Actualize the statistics of the factory
		stats.add(String.format("Created thread %d with name %s on %s\n",t.getId(),t.getName(),new Date()));
		return t;
	}
	
	/**
	 * Method that returns the statistics of the ThreadFactory 
	 * @return The statistics of the ThreadFactory
	 */
	public String getStats(){
		StringBuffer buffer=new StringBuffer();
		Iterator<String> it=stats.iterator();
		
		while (it.hasNext()) {
			buffer.append(it.next());
		}
		
		return buffer.toString();
	}

}
