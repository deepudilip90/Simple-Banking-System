package banking;

import java.util.*;


public class Main {

    public static void main(String[] args) {

    Integer userInput = getUserInput();
    AccountManager accountManager = new AccountManager();
    accountManager.processChoice(userInput);

    }

    public static Integer getUserInput(){
        Scanner reader = new Scanner(System.in);
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit account");
        Integer choice = reader.nextInt();
        reader.close();
        return choice;
    }


}