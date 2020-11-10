package codeWars;

import java.util.ArrayList;
import java.util.List;

public class CinemaCashier {
    private static final int PRICE = 25;

    public static void main(String[] args) {
        System.out.println(sellTickets(new int[] {25, 25, 25, 25, 25, 50, 50, 50, 50}));    
    }
    
    
    public static String sellTickets(int[] peopleInLine)
    {
        List<Integer> cashier = new ArrayList<>();
        String canServeAll = "YES";
        for (int cash : peopleInLine) {
            int change = cash - PRICE;
            if (change == 0)
            {
                cashier.add(cash);
            }
            else if (change > 0 && cashier.contains(change))
            {
                cashier.remove((Integer) change);
                cashier.add(cash);
            }
            else
            {
                canServeAll = "NO";
            }
        }
        return canServeAll;
    }
}
