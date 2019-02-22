package io.zipcoder.casino;

public class Balance {
    private Integer balance;

    public Balance(){
        this.balance = 0;

    }

    public Balance(Integer balance){
        this.balance = balance;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
