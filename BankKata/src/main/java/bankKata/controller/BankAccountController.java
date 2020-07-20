package bankKata.controller;

import bankKata.view.Printer;
import bankKata.model.AccountNumberReader;

import java.util.List;

public class BankAccountController {

    public static void main(String[] args) {

        AccountNumberReader accountNumberReader = new AccountNumberReader();
        List<List<Integer>> accountNumbers = accountNumberReader.readAccountNumberFile(args[0]);
        CheckSumCalculator checkSumValidator = new CheckSumCalculator();

        for (List<Integer> accountNumber : accountNumbers) {
            boolean isValid = checkSumValidator.validate(accountNumber);
            if (isValid) {
                Printer.printValidAccountNumber(accountNumber);
            }
        }
    }
}
