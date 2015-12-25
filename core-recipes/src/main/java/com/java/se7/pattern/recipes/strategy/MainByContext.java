package com.java.se7.pattern.recipes.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vf-root on 5/27/15.
 */
public class MainByContext {

    public static void main(String[] args){
        String response = "EditorialBoard";

        Map<String, IResponseHandler> strategyHandlers = new HashMap<String,IResponseHandler>();
        strategyHandlers.put("EditorialOffice", new EditorialOfficeHandler());
        strategyHandlers.put("EditorialBoard", new EditorialBoardHandler());

        HandlerContext context = new HandlerContext();
        // this should be set automatically.
        context.setHandler(strategyHandlers.get(response));

        context.applyStrategy("xxp");
    }
}
