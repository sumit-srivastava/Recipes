package com.java.se7.pattern.recipes.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vf-root on 5/27/15.
 */
public class Main {

    public static void main(String[] args){

        String soapResponse = "EditorialOffice";

        Map<String, IResponseHandler> strategyHandlers = new HashMap<String,IResponseHandler>();
        strategyHandlers.put("EditorialOffice", new EditorialOfficeHandler());
        strategyHandlers.put("EditorialBoard", new EditorialBoardHandler());

        IResponseHandler responseHandler = strategyHandlers.get(soapResponse);
        responseHandler.handleResponse("xxp");

    }
}
