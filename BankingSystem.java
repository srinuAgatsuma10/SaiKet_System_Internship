import java.util.*;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            transactionHistory.add("Deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            transactionHistory.add("Withdrew $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return this.transactionHistory;
    }
}

public class BankingSystem {
    private HashMap<String, BankAccount> accounts;

    public BankingSystem() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolder) {
        if (!accounts.containsKey(accountNumber)) {
            BankAccount account = new BankAccount(accountNumber, accountHolder);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account number already exists.");
        }
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.createAccount("123456", "John Doe");

        BankAccount account = bankingSystem.getAccount("123456");
        account.deposit(1000);
        account.withdraw(500);

        System.out.println("Current Balance: $" + account.getBalance());

        ArrayList<String> transactionHistory = account.getTransactionHistory();
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
