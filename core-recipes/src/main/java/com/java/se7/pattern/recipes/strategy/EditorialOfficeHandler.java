package com.java.se7.pattern.recipes.strategy;

// Concrete class for EditorialOffice response
class EditorialOfficeHandler implements IResponseHandler {

    public void handleResponse(String xxp) {
        System.out.println("Handling editorial office...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //
        }
        System.out.println("Done...");
    }
}
