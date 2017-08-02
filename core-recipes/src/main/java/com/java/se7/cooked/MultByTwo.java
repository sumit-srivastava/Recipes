package com.java.se7.cooked;

/**
 * Created by ssri52 on 2/27/2017.
 */
public class MultByTwo {
    public static void main(String[] args) {
        int i;
        int num = 6;
        for (i=0; i<4; i++) {
            num = num << 1;
            System.out.println(num);
        }
    }
}
