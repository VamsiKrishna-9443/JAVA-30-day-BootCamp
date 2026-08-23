package Execrise;

class InsufficientFundsException extends Exception
{
    InsufficientFundsException(String message)
    {
        super(message);
    }
}

public class BankAccount
{
    int accountNumber;
    String name;
    double balance;

    BankAccount(int accountNumber, String name, double balance)
    {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount)
    {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Balance: " + balance);
    }

    void withdraw(double amount) throws InsufficientFundsException
    {
        if(amount > balance)
        {
            throw new InsufficientFundsException(
                    "Insufficient funds. Available balance: " + balance
            );
        }

        balance = balance - amount;

        System.out.println("Withdrawn: " + amount);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args)
    {
        BankAccount account =
                new BankAccount(101, "Vamsi", 5000);

        System.out.println("Account Holder: " + account.name);
        System.out.println("Initial Balance: " + account.balance);

        account.deposit(2000);

        try
        {
            account.withdraw(3000);
            account.withdraw(6000);
        }
        catch(InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("Final Balance: " + account.balance);
    }
}