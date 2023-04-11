package pack1;
import java.util.Scanner;

 class BankAccount {
    public String name;
    private String password;
    private double balance;
    private String transHistory = "";
    public String getName() {
        return name;
    }

public BankAccount(String name) {
            this.name = name;
        }
		public BankAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name : ");
        name = sc.nextLine();
        System.out.print("Enter Password : ");
        password = sc.nextLine();
        System.out.print("Enter Initial Balance : ");
        balance = sc.nextDouble();
        System.out.println("\n\n********ACCOUNT CREATED SUCCESSFULLY********\n");
    }

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Name : ");
        String userName = sc.nextLine();
        System.out.print("Enter Password : ");
        String pass = sc.nextLine();

        if (userName.equals(name) && pass.equals(password)) {
            return true;
        }
        else {
            System.out.println("\nInvalid Credentials. Please Try Again.\n");
            return false;
        }
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Withdraw Amount : ");
        double amount = sc.nextDouble();

        if (amount > balance) {
            System.out.println("\nInsufficient Balance. Cannot Withdraw.\n");
            return;
        }

        balance -= amount;
        System.out.println("\n" + amount + " Withdrawn Successfully.\n");

        transHistory += String.format("\n%-15s%-15s%-15s%-15s", "Withdraw", amount, balance, "");
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Deposit Amount : ");
        double amount = sc.nextDouble();

        balance += amount;
        System.out.println("\n" + amount + " Deposited Successfully.\n");

        transHistory += String.format("\n%-15s%-15s%-15s%-15s", "Deposit", amount, balance, "");
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Account Holder's Name : ");
        String recipientName = sc.nextLine();
        System.out.print("Enter Transfer Amount : ");
        double amount = sc.nextDouble();

        if (amount > balance) {
            System.out.println("\nInsufficient Balance. Cannot Transfer.\n");
            return;
        }

        balance -= amount;
        System.out.println("\n" + amount + " Transferred Successfully to " + recipientName + ".\n");

        transHistory += String.format("\n%-15s%-15s%-15s%-15s", "Transfer", amount, balance, recipientName);
    }

    public void checkBalance() {
        System.out.println("\nCurrent Balance : " + balance + "\n");
    }

    public void transHistory() {
        System.out.println("\n\n**********TRANSACTION HISTORY**********");
        System.out.println(String.format("\n%-15s%-15s%-15s%-15s", "Type", "Amount", "Balance", "Recipient"));
        System.out.println(transHistory + "\n");
    }
}
