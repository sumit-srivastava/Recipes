package com.java.se7.pattern.recipes.strategy;

/**
 * Not necessary, handler interface can be used directly as in Main
 */
public class HandlerContext {

    private IResponseHandler handler;

    public void setHandler(IResponseHandler handler) {
        this.handler = handler;
    }

    public void applyStrategy(String xxp){
        handler.handleResponse(xxp);
    }
}
