package com.java.se7.pattern.recipes.observer;

interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}


