package com.java.se7.cooked;

/**
 * Created by ssri52 on 12/7/2015.
 */
public class IdentifyInteger {

    public static void main(String[] args) {
        // with any number just perform % 1 and see if its not equivalent to 0.
        if(Math.sqrt(3*3 + 5*4) % 1 == 0){
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println("Actual: " + Math.sqrt(3*3 + 5*4) % 1);

        System.out.println("Actual: " + (25.4 % 3));
    }
}
