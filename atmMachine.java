import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM_Machine {

    private static double balance = 1000; // initial balance
    private static List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ATM Machine:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    showTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    private static void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance. Please try again.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawal: ₹" + amount);
            System.out.println("Please collect your cash. Your remaining balance is: ₹" + balance);
        }
    }

    private static void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ₹");
        double amount = scanner.nextDouble();
        balance += amount;
        transactionHistory.add("Deposit: ₹" + amount);
        System.out.println("Deposit successful. Your new balance is: ₹" + balance);
    }

    private static void transferMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to transfer: ₹");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance. Please try again.");
        } else {
            balance -= amount;
            transactionHistory.add("Transfer: ₹" + amount);
            System.out.println("Transfer successful. Your remaining balance is: ₹" + balance);
        }
    }

    private static void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
