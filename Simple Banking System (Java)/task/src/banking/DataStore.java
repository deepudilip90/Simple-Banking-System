package banking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DataStore {
    List<Account> allAccounts;
    Set<Long> accountIds;

    public DataStore(){
        this.allAccounts = new ArrayList<Account>();
        this.accountIds = new HashSet<>();
    }

    public void addAccount(Account account){
        allAccounts.add(account);
    }


}
