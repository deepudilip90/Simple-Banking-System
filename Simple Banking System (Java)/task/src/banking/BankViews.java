package banking;

import java.util.Scanner;

class BankViews {
    private final Scanner reader = new Scanner(System.in);

    BankViews() {
    }
    private long getNumInput(){
        while (true) {
            if (reader.hasNextInt()) {
                return reader.nextInt();
            } else if (reader.hasNextLong()) {
                return reader.nextLong();
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                reader.next();
            }
        }
    }

    int showLandingPage() {
        System.out.println("\n");
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
        return (int) getNumInput();
    }

    long getAccountIdInput() {
        System.out.print("Enter your card number:\n");
        return getNumInput();
    }

    int getAccountIdPin() {
        System.out.print("Enter your PIN:\n");
        return (int) getNumInput();
    }

    int showAccountMenu() {
        System.out.println("1. Balance");
        System.out.println("2. Logout");
        System.out.println("0. Exit");
        return reader.nextInt();
    }

    void showExitMessage() {
        System.out.println("Bye!");
    }

    void showAccountCreationMessage( Long accountId, Integer accountPin) {
        System.out.println("Your card has been created");
        System.out.printf("Your card number:\n%d\n", accountId);
        System.out.printf("Your card PIN:\n%04d", accountPin);
    }

    void showLoginSuccessMessage() {
        System.out.println("\nYou have successfully logged in!\n");
    }
    void showInvalidLoginMessage() {
        System.out.println("Wrong card number of PIN!");
    }

    void showAccountBalance(int balance) {
        System.out.printf("Your card balance is:\n %d\n", balance);
    }

    void showLogOutMessage() {
        System.out.println("\nYou have successully logged out!");
    }

    void showInvalidChoice(){
        System.out.println("Invalid choice. Plesae enter valid input!");
    }
}


