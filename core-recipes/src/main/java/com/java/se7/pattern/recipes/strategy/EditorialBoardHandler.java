package com.java.se7.pattern.recipes.strategy;

// Concrete class for EditorialBoard response
class EditorialBoardHandler implements IResponseHandler {

    public void handleResponse(String xxp) {
        System.out.println("Handling editorial board...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //
        }
        System.out.println("Done...");
    }
}
