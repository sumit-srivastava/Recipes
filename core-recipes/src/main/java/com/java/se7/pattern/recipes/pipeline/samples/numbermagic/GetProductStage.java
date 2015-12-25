package com.java.se7.pattern.recipes.pipeline.samples.numbermagic;

import com.java.se7.pattern.recipes.pipeline.BaseError;
import com.java.se7.pattern.recipes.pipeline.PipelineContext;
import com.java.se7.pattern.recipes.pipeline.Stage;

/**
 * A sample stage class to demonstrate the usage of Pipeline Pattern
 * 
 * calculates the product of all numbers in array
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 *  
 */

public class GetProductStage implements Stage {

	@Override
	public void execute(PipelineContext context) {
		NumberMagicContext nmContext = (NumberMagicContext)context;
		int[] numbers = nmContext.getInput();
		if (numbers == null){
			BaseError error = new BaseError("EMPTY_INPUT", "The input is an empty list", null);
			nmContext.addError(error);			
		}
		int product =1;
		for (int number: numbers ){
			product *=number;
		}
		nmContext.setOffset(product);		
	}

}
