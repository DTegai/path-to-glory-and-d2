package codeWars;

import java.util.Arrays;

public class CarPrice {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nbMonths(2000, 8000, 1000, 1.5)));
    }

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingPerMonth, double percentLossByMonth) {
        double priceDecreasePerMonth = percentLossByMonth;
        double oldCarPrice = startPriceOld;
        double newCarPrice = startPriceNew;
        int savings = 0;
        int month = 0;
        while (oldCarPrice + savings < newCarPrice) {
            month++;
            savings += savingPerMonth;

            if (month % 2 == 0 && month > 0) {
                priceDecreasePerMonth += 0.5;
            }
            oldCarPrice = oldCarPrice * (100 - priceDecreasePerMonth) / 100;
            newCarPrice = newCarPrice * (100 - priceDecreasePerMonth) / 100;
        }
        int remaining = (int)Math.round(oldCarPrice + savings - newCarPrice);
        return new int[]{month, remaining};
    }
}

