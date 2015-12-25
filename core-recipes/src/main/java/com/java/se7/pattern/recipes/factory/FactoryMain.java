package com.java.se7.pattern.recipes.factory;

// Factory client code
public class FactoryMain {

    public static void main(String args[]) {
        String country = args[0];
        Currency rupee = CurrencyFactory.createCurrency(country);
        System.out.println(rupee.getSymbol());
    }
}
