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
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
        return (int) getNumInput();
    }

    long getAccountIdInput() {
        System.out.print("Enter Account ID: ");
        return getNumInput();
    }

    int getAccountIdPin() {
        System.out.print("Enter PIN for provided Account ID: ");
        return (int) getNumInput();
    }

    int showAccountMenu() {
        System.out.println("\nAccount Menu");
        System.out.println("1. Balance");
        System.out.println("2. Logout");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
        return reader.nextInt();
    }

    void showExitMessage() {
        System.out.println("Exiting Application!");
    }

    void showAccountCreationMessage( Long accountId, Integer accountPin) {
        System.out.println("Your card has been created");
        System.out.printf("Your card number:\n%d\n", accountId);
        System.out.printf("Your card PIN:\n%04d\n", accountPin);
    }

    void showLoginSuccessMessage() {
        System.out.println("You have successfully logged in!");
    }

    void showInvalidPinMessage() {
        System.out.println("Invalid PIN provided! Sign in failed!");
    }

    void showInvalidAccountIdMessage() {
        System.out.println("Account Id does not exist! Sign in failed!");
    }

    void showAccountBalance(double balance) {
        System.out.printf("Your card balance is:\n %f\n", balance);
    }

    void showLogOutMessage() {
        System.out.println("You have successully logged out!");
    }

    void showInvalidChoice(){
        System.out.println("Invalid choice. Plesae enter valid input!");
    }
}


