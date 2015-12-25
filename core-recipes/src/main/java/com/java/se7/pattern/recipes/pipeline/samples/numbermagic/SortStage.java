package com.java.se7.pattern.recipes.pipeline.samples.numbermagic;

import com.java.se7.pattern.recipes.pipeline.PipelineContext;
import com.java.se7.pattern.recipes.pipeline.Stage;

import java.util.Arrays;

/**
 * A sample Stage class to demonstrate the usage of Pipeline Pattern
 * 
 * sorts an array of numbers
 * 
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class SortStage implements Stage {

	@Override
	public void execute(PipelineContext context) {
		NumberMagicContext nmContext = (NumberMagicContext)context;
		int[] sortedValues =Arrays.copyOf(nmContext.getIncreasedValues(),nmContext.getIncreasedValues().length );
		Arrays.sort(sortedValues);
		nmContext.setSortedValues(sortedValues);		
	}

}
