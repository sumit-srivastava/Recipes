package com.java.se7.pattern.recipes.factory;

// Concrete Rupee Class code
class Rupee implements Currency {

    @Override
    public String getSymbol() {
        return "Rs";
    }
}
