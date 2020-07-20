package bankKata.controller;


import bankKata.controller.BankAccountController;
import org.junit.Test;

public class TestBankAccountController {

    @Test
    public void testWorkflow() {
        BankAccountController.main(new String[] {"src/example.txt"});
    }
}