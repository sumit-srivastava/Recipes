package com.java.se7.cooked;

/**
 * Created by vf-root on 2/25/15.
 */
public class InstanceOfMain {

    public static void main(String[] args){
        Object obj1 = new ScanNext();
        Object obj2 = new ShortDemo();

        if (obj1 instanceof ScanNext)
            System.out.print("1: " + true);

        if (obj1 instanceof ShortDemo)
            System.out.print("2: " + true);

    }
}
