package banking;

import java.util.*;


public class Main {

    public static void main(String[] args) {
    RequestHandler requestHandler = new RequestHandler();
    AccountManager accountManager = new AccountManager();

    RequestHandler.showLandingPage();
    Integer userInput = requestHandler.getUserInput();
    accountManager.processChoice(userInput);

    }




}