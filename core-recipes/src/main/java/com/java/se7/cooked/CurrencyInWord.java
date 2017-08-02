package com.java.se7.cooked;

/**
 * Created by ssri52 on 2/28/2017.
 */
public class CurrencyInWord {

    private static final String[] specialNames = {
            "",
            " Thousand ",
            " Million ",
            " Billion ",
            " Trillion ",
            " Quadrillion ",
            " Quintillion "
    };

    private static final String[] tenMultipleNumbers = {
            "Ten",
            " Twenty ",
            " Thirty ",
            " Forty ",
            " Fifty ",
            " Sixty ",
            " Seventy ",
            " Eighty ",
            " Ninety "
    };

    private static final String[] numbers = {
            " One ",
            " Two ",
            " Three ",
            " Four ",
            " Five ",
            " Six ",
            " Seven ",
            " Eight ",
            " Nine ",
            " Ten ",
            " Eleven ",
            " Twelve ",
            " Thirteen ",
            " Fourteen ",
            " Fifteen ",
            " Sixteen ",
            " Seventeen ",
            " Eighteen ",
            " Nineteen "
    };

    public String convert(int number) {
        if (number == 0)
            return "Zero";

        String prefix = "";

        if (number < 0) {
            number = -number;
            prefix =  "Negative";
        }

        String current = "";
        int place = 0;

        do {
            int n = number % 1000;
            if (n != 0) {
                String s = convertLessThanOneThousand(n);
                current = s + specialNames[place] + current;
            }
            place++;
            number /= 1000;
        } while(number > 0);

        return (prefix + current).trim();
    }

    private String convertLessThanOneThousand(int number) {
        String firstTwoPlace;
        int twoDigits = number % 100;
        if (twoDigits == 0) {
            firstTwoPlace = "";
        } else if (twoDigits < 20) {
            firstTwoPlace = numbers[twoDigits-1];
        } else {
            firstTwoPlace = tenMultipleNumbers[(twoDigits/10)-1];
            if (twoDigits%10 != 0) {
                firstTwoPlace += numbers[(twoDigits%10)-1];
            }
        }
        if (number / 100 == 0) {
            return firstTwoPlace;
        } else {
            return numbers[(number/100)-1] + "Hundred" + firstTwoPlace;
        }
    }

    public static void main(String[] args) {
        CurrencyInWord object = new CurrencyInWord();
        System.out.println(object.convert(1234567890));
    }
}
