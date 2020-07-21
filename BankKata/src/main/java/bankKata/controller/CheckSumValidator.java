
package bankKata.controller;

import java.util.List;


public class CheckSumValidator {

    private static final int CHECKSUM = 11;

    public boolean validate(List<Integer> accountNumber) {

        if (accountNumber.contains(-1)) {
            throw new IllegalArgumentException("There was a unreadable digit in the number");
        }
        return checkNumberInternal(accountNumber);
    }

    /**
     * The algorithm for this is:
     * (d1+2d2+3d3+...+9*d9) mod checksum = 0
     */
    private boolean checkNumberInternal(List<Integer> accountNumber) {

        int sum = 0;
        int multiplicator = 1;

        for (int i = accountNumber.size() - 1; i >= 0; i--) {
            sum += (accountNumber.get(i) * multiplicator);
            multiplicator++;
        }
        return sum % CHECKSUM == 0;
    }

}