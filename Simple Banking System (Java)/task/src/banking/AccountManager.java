package banking;


import java.util.Random;

public class AccountManager {
    DataStore datastore;
    private static final Random random = new Random();

    public AccountManager(){
        this.datastore = new DataStore();
    }
    private Long createAccountId(){
        long number;

        do {
            number = 4_000_000_000_000_000L + random.nextLong(10_000_000_000L);
        } while (datastore.accountIds.contains(number));
        return number;
    }

    private Integer createAccountPint(){
        return random.nextInt(10000);
    }
    public  void processChoice(int choice){
        switch (choice){
            case 1:
                Long accountId = createAccountId();
                Integer accountPin = createAccountPint();
                Account newAccount = new Account(accountId, accountPin);
                datastore.allAccounts.add(newAccount);
                System.out.println("Your card has been created");
                System.out.printf("Your card number:\n %d\n", accountId);
                System.out.printf("Your card PIN:\n %04d", accountPin);

        }
    }
}
