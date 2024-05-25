import java.util.Scanner;

public class Atm {
    public static void main(String args[]) {
        final int DEFAULT_PIN = 12345;
        int balance = 500000, withdraw, deposit, pin;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to ICICI Bank ATM");
        System.out.print("Please enter your PIN: ");
        pin = sc.nextInt();
        
        if (pin != DEFAULT_PIN) {
            System.out.println("Incorrect PIN! Exiting...");
            System.exit(0);
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("Press 1 to Withdraw money");
            System.out.println("Press 2 to Deposit money");
            System.out.println("Press 3 to Know your balance");
            System.out.println("Press 4 to Transfer money");
            System.out.println("Press 5 to Close the session");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to be withdrawn:");
                    withdraw = sc.nextInt();
                    if (balance >= withdraw) {
                        balance -= withdraw;
                        System.out.println("Please collect your cash!");
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    break;
                case 2:
                    System.out.println("Enter the amount to be deposited:");
                    deposit = sc.nextInt();
                    balance += deposit;
                    System.out.println("Amount Successfully Deposited!");
                    break;
                case 3:
                    System.out.println("Current Balance: " + balance);
                    break;
                case 4:
                    System.out.println("Enter the Account holder name:");
                    String name = sc.nextLine();
                    System.out.println("Enter the account number:");
                    int num = sc.nextInt();
                    System.out.println("Enter the amount to be transferred:");
                    int amt = sc.nextInt();
                    if (amt > balance) {
                        System.out.println("Insufficient amount!!!");
                    } else {
                        System.out.print("Enter the PIN: ");
                        int transferPin = sc.nextInt();
                        if (transferPin == DEFAULT_PIN) {
                            balance -= amt;
                            System.out.println("Amount Transferred Successfully!!!");
                        } else {
                            System.out.println("Incorrect PIN!!!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using ICICI Bank ATM. Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
