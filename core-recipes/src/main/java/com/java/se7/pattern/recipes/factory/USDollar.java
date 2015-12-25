package com.java.se7.pattern.recipes.factory;

// Concrete US Dollar code
class USDollar implements Currency {

    @Override
    public String getSymbol() {
        return "USD";
    }
}
