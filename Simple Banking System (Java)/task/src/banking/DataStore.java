package banking;
import java.util.*;

class DataStore {
    Map<Long, Account> allAccounts;

    public DataStore(){
        this.allAccounts = new HashMap<>();
    }

    public void addAccount(Account account){
        allAccounts.put(account.accountId, account);
    }
    public boolean checkAccountExists(long accountId){
        return allAccounts.containsKey(accountId);
    }

    public Account getAccount(long accountId){
        return allAccounts.get(accountId);
    }

}
