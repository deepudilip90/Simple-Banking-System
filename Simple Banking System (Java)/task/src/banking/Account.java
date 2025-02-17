package banking;

class Account{
    Long accountId;
    int accountPin;

    public Account (Long accountId, int accountPin){
       setAccountId(accountId);
       setAccountPin(accountPin);
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public Long getAccountId() {
        return accountId;
    }

}