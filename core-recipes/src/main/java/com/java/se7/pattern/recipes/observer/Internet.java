package com.java.se7.pattern.recipes.observer;

class Internet implements Observer {

    @Override
    public void update(float interest) {
        System.out.println("Internet: Interest Rate updated, new Rate is: "  + interest);
    }
}
