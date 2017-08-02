package com.java.se7.data.structures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Stock span problem
 *
 * We are given a list of prices of a stock for N number of days.
 * We need to find stock span for each day. Span is defined as number of consecutive days
 * before the given day where the price of stock was less than or equal to price at given day.
 * For example, {100, 60,70,65, 80, 85} span for each day will be {1, 1, 2, 1, 4, 5}.
 *
 * For first day span is always 1. In example, notice that on day 2, price of stock is 60
 * and there is no day prior to it where price was less than 60. Hence span for day 2 is 1 again.
 * For day 3, price at day 2 (60) is less than 70, hence span for day 3 is 2. Similarly, for day 4
 * and day 5. Remember days should be consecutive, that why span for day 4 is 1 even though there
 * was a day 2 where price was less than 65.
 *
 * http://algorithmsandme.in/2014/02/stock-span-problem/
 */
public class StockSpanSolution {

    private static List<Integer> getStockSpan(List<Integer> stockPriceList) {
        List<Integer> stockSpanList = new ArrayList<>();
        stockSpanList.add(0, 1);

        Stack<Integer> stack = new ArrayStack<>();
        stack.push(0);

        for (int i=1; i<stockPriceList.size(); i++) {
            while (!stack.isEmpty() && (stockPriceList.get(stack.top()) < stockPriceList.get(i))) {
                stack.pop();
            }
            stockSpanList.add(i, i - stack.top());
            stack.push(i);
        }
        return stockSpanList;
    }

    public static void main(String[] args) {
        List<Integer> stockPriceList = new ArrayList<>();
        stockPriceList.add(100);
        stockPriceList.add(60);
        stockPriceList.add(70);
        stockPriceList.add(65);
        stockPriceList.add(80);
        stockPriceList.add(85);

        List<Integer> stockSpanList = getStockSpan(stockPriceList);
        System.out.println(Arrays.toString(stockSpanList.toArray()));
    }
}
