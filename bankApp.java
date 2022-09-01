import java.util.Scanner;

public class bankApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name and press the enter key:");
        String name = scanner.nextLine();
        System.out.println("Please enter your customer ID and press the enter key:");
        String customerId = scanner.nextLine();
        BankAccount acc = new BankAccount(name, customerId);
        acc.showMenu();
    }
}


class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cusName, String cusId) {
        customerName = cusName;
        customerId = cusId;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No Transaction occurred");
        }
    }

    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. PreviousTransaction");
        System.out.println("0. Exit");

        do {
            System.out.println(
                    "==============================================================================================");
            System.out.print("Please enter an option: ");
            option = scanner.next().charAt(0);
            System.out.println(
                    "==============================================================================================");
            System.out.println("\n");
            switch (option) {
                case '1' -> {
                    System.out.println("----------------------------------");
                    System.out.println("Your current Balance is: " + balance);
                    System.out.println("----------------------------------");
                    System.out.println("\n");
                }
                case '2' -> {
                    System.out.println("----------------------------------");
                    System.out.print("Please enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("Amount successfully credited into your account...");
                    System.out.println("\n");
                    System.out.println("----------------------------------");
                }
                case '3' -> {
                    System.out.println("----------------------------------");
                    System.out.print("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("Amount successfully debited from your account...");
                    System.out.println("\n");
                    System.out.println("----------------------------------");
                }
                case '4' -> {
                    System.out.println("----------------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------------");
                    System.out.println("\n");
                }
                case '0' -> System.out.println("***********************************");
                default -> System.out.println("Invalid option! Please try again... ");
            }
        } while (option != '0');
        System.out.println("Thank you for banking with Bank of America.");
    }
}

