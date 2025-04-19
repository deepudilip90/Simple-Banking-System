package banking;

class Account{
    Long accountId;
    byte[] accountPinHash;
    int accountBalance;

    public Account (Long accountId, byte[] accountPinHash){
       this.accountId = accountId;
       this.accountPinHash = accountPinHash;
       this.accountBalance = 0;
    }

    public byte[] getAccountPintHash(){
        return this.accountPinHash;
    }

    public int getAccountBalance(){
        return this.accountBalance;
    }

}