package banking;

class Account{
    Long accountId;
    byte[] accountPinHash;
    double accountBalance;

    public Account (Long accountId, byte[] accountPinHash){
       this.accountId = accountId;
       this.accountPinHash = accountPinHash;
       this.accountBalance = 0;
    }

    public byte[] getAccountPintHash(){
        return this.accountPinHash;
    }

    public double getAccountBalance(){
        return this.accountBalance;
    }

}