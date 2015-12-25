package com.java.se8.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        List<String>  names = new ArrayList();
        names.add( "David");
        names.add( "Sam");
        names.add( "Ben");

        Supplier<SupplierTest> c1 = () -> new SupplierTest();
        SupplierTest a1 = c1.get();
        SupplierTest a2 = c1.get();
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());

        for (String name: names) {
            printNames(() -> name);
        }
    }

    public  static void printNames(Supplier arg) {
        System.out.println(arg.get());
        System.out.println(arg.get().hashCode());
        System.out.println(arg.get());
        System.out.println(arg.get().hashCode());
    }

}
