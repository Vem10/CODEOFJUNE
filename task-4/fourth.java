import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful.");
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1:
                performWithdrawal();
                break;
            case 2:
                performDeposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Exiting the ATM.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void performWithdrawal() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = getDoubleInput();

        account.withdraw(amount);
    }

    public void performDeposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = getDoubleInput();

        account.deposit(amount);
    }

    public void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Current balance: " + balance);
    }

    private double getDoubleInput() {
        double input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                input = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
        return input;
    }
}

public class fourth {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);

        while (true) {
            atm.displayMenu();

            int choice = getIntInput();

            atm.processChoice(choice);
        }
    }

    private static int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
        return input;
    }
}
