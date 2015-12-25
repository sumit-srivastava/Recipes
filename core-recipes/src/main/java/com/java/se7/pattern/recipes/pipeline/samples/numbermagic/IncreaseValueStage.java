package com.java.se7.pattern.recipes.pipeline.samples.numbermagic;

import com.java.se7.pattern.recipes.pipeline.PipelineContext;
import com.java.se7.pattern.recipes.pipeline.Stage;

import java.util.Arrays;

/**
 * A sample stage class to demonstrate the usage of Pipeline Pattern
 * 
 * increases the value of each of the elements in the array by adding another number
 * 
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */

public class IncreaseValueStage implements Stage {
	
	public void execute(PipelineContext context) {
		NumberMagicContext nmContext = (NumberMagicContext)context;
		nmContext.setIncreasedValues(Arrays.copyOf(nmContext.getInput(),nmContext.getInput().length ));
		int[] numbers = nmContext.getIncreasedValues();
		for (int i =0; i < numbers.length; i++){
			numbers[i] += nmContext.getOffset();
		}		
	}

}
