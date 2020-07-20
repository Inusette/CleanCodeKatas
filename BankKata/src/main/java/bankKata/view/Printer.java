package bankKata.view;

import java.util.List;


public class Printer {

    public static void printValidAccountNumber(List<Integer> accountNumber) {
        for (int digit : accountNumber) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }
}