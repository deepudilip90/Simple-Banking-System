package banking;


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Arrays;

public class BankController {
    DataStore datastore;
    private static final Random random = new Random();
    private final BankViews views;

    public BankController() {
        this.datastore = new DataStore();
        this.views = new BankViews();
    }

    public void start() {
        boolean appRunning = true;
        while (appRunning) {
            int userInput = views.showLandingPage();
            switch (userInput) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    signIn();
                    break;
                case 0:
                    views.showExitMessage();
                    appRunning = false;
            }
        }
    }

    private Long createAccountId() {
        long number;
        do {
            number = 4_000_000_000_000_000L + random.nextLong(10_000_000_000L);
        } while (datastore.allAccounts.containsKey(number));
        return number;
    }

    private Integer createAccountPin() {
        return random.nextInt(10000);
    }

    private void createAccount() {
        Long accountId = createAccountId();
        Integer accountPin = createAccountPin();
        Account newAccount = new Account(accountId, getHash(String.valueOf(accountPin))); // [ -94, -89, 34, -33, 103, 65, -123, -76, 90, -28, 117, 42, 30, 125, 84, 68 ]
        datastore.addAccount(newAccount); // [ -94, -89, 34, -33, 103, 65, -123, -76, 90, -28, 117, 42, 30, 125, 84, 68 ]
        views.showAccountCreationMessage(accountId, accountPin);

    }
    private void signIn() {
        long accountId = views.getAccountIdInput();
        int pin = views.getAccountIdPin();
        if (datastore.checkAccountExists(accountId)) {

            Account curAccount = datastore.getAccount(accountId);

            byte[] pinHash = getHash(String.valueOf(pin));
            if (Arrays.equals(pinHash,curAccount.getAccountPintHash())) {
                views.showLoginSuccessMessage();
                boolean signedIn = true;
                while (signedIn) {
                    signedIn = handleAccount(curAccount);
                }
            } else {
                views.showInvalidPinMessage();
            }
        } else {
            views.showInvalidAccountIdMessage();
        }
    }

    private boolean handleAccount(Account account) {

        int choice = views.showAccountMenu();
        switch (choice) {
            case 1:
                double balance = account.getAccountBalance();
                views.showAccountBalance(balance);
                return true;
            case 2:
                views.showLogOutMessage();
                return false;
            case 0:
                views.showExitMessage();
                System.exit(0);
                return false;
            default:
                views.showInvalidChoice();
                return true;

        }

    }

    private static byte[] getHash(String inputString) {
        try {
            byte[] bytesOfMessage = inputString.getBytes(StandardCharsets.UTF_8);

            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.digest(bytesOfMessage);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}






