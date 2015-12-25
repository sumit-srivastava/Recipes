package com.java.se7.pattern.recipes.pipeline.samples.numbermagic;

import com.java.se7.pattern.recipes.pipeline.Pipeline;
import com.java.se7.pattern.recipes.pipeline.SequentialPipeline;

/**
 * A sample client class to demonstrate the usage of Pipeline Pattern
 * 
 * Takes an array of integers as input and does the following 
 * calculate the product of all numbers
 * Increase each value in the array by adding the product
 * sort the numbers
 * the sorted list is returned
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */

public class NumberMagicWithProduct {
	
	private static  final Pipeline S_PIPELINE = new SequentialPipeline();
	
	static{
		S_PIPELINE.addStage(new GetProductStage ());
		S_PIPELINE.addStage(new IncreaseValueStage ());
		S_PIPELINE.addStage(new SortStage ());
	}
	
	
	
	public int[]  doMagic(int[] numbers){
		NumberMagicContext nmContext = new NumberMagicContext ();
		nmContext.setInput(numbers);
		S_PIPELINE.execute(nmContext);
		return nmContext.getSortedValues();
	}

}
