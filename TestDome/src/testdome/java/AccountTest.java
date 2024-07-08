package testdome.java;

import org.junit.Assert;
import org.junit.Test;

//Correct

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void depositWillNotAcceptNegativeAmount(){
        Account account = new Account(0);
        Assert.assertFalse(account.deposit(-20));
    }

    @Test
    public void withdrawWillNotAcceptNegativeAmount(){
        Account account = new Account(0);
        Assert.assertFalse(account.withdraw(-20));
    }

    @Test
    public void accountCannotOverstepOverdraftLimit(){
        Account account = new Account(10);
        Assert.assertFalse(account.withdraw(20));
    }

    @Test
    public void depositCorrectAmount(){
        Account account = new Account(0);
        double originalBalance = account.getBalance();
        double amount = 10;
        Assert.assertTrue(account.deposit(amount));
        Assert.assertEquals(account.getBalance(), (originalBalance + amount), 0.0);
    }

    @Test
    public void withdrawCorrectAmount(){
        Account account = new Account(0);
        account.deposit(30);
        double originalBalance = account.getBalance();
        double amount = 10;
        Assert.assertTrue(account.withdraw(amount));
        Assert.assertEquals(account.getBalance(), (originalBalance - amount), 0.0);
    }


}