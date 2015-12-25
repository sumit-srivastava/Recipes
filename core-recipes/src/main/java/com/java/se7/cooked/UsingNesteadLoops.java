package com.java.se7.cooked;

public class UsingNesteadLoops {

    /**
     * Declare a String Array
     */
    private static String[] strArray = { "Cat", "Dog", "Tiger", "Lion", "Lion" };

    /**
     * @param args
     */
    public static void main(String[]args) {
        isThereDuplicateUsingLoops(strArray);

    }

    /**
     * Iterates the String array and find out the duplicates in Array
     *
     * @param strArray
     * Array of values to find the duplicates
     */
    public static void isThereDuplicateUsingLoops(String[]strArray){

        boolean duplicateFound=false;
        int loopCounter=0;

        for(int i=0;i<strArray.length;i++){
            String str=strArray[i];
            int countDuplicate=0;

            for(int j=0;j<strArray.length;j++){
                String str2=strArray[j];
                if(str.equalsIgnoreCase(str2)){
                countDuplicate++;
                }
                if(countDuplicate>1){
                    duplicateFound=true;
                    System.out.println("Duplicates Found for " +str);
                }
                loopCounter++;
            }// end of inner nested for loop

            if(duplicateFound){
                break;
            }
        }// end of outer for loop

        System.out.println("Looped " +loopCounter + " times to find the result");
    }

}
