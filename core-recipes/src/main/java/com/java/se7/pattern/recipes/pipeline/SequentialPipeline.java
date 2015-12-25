package com.java.se7.pattern.recipes.pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * The sequential pipeline executes the stage sequence imitating a try catch finally block.
 * try {
 * 			execute stages
 * }
 * catch (any error){
 *          execute error stages
 * }
 * finally {
 * 			execute finally stages
 * }
 * 
 * Please note that 
 * 
 * @author Benoy Antony (benoy@ideaimpl.com)(http://www.ideaimpl.com)
 *
 */
public class SequentialPipeline implements Pipeline {

	private List<Stage> m_stages = new ArrayList<Stage> ();
	private List<Stage> m_errorStages= new ArrayList<Stage> ();
	private List<Stage> m_finalStages= new ArrayList<Stage> ();	
	
	public void addStage(Stage stage) {
		m_stages.add(stage);

	}

	public void addErrorStage(Stage stage) {
		m_errorStages.add(stage);
	}
	
	public void addFinalStage(Stage stage) {
		m_finalStages.add(stage);
		
	}
		
	public void execute(PipelineContext context) {
		/* execute the stages */
		for (Stage stage:m_stages){
			
			stage.execute(context);
			
			if (context.getErrors()!= null && !context.getErrors().isEmpty()){
				break;
			}

		}
		/* if any error occurred, execute the error stages*/
		if (context.getErrors()!= null && !context.getErrors().isEmpty()){
			for (Stage errorStage: m_errorStages){
				errorStage.execute(context);
			}			
		}
		//execute the final stages
		for (Stage finalStage: m_finalStages){
			finalStage.execute(context);
		}
	}

}
