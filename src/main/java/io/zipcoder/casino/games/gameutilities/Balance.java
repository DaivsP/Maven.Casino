package io.zipcoder.casino.games.gameutilities;

public class Balance {
    private Integer balance;
    private Console console ;

    public Balance(){
        this.balance = 0;
        this.console = new Console(System.in, System.out);

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

    public void addMoreChips(){
        balance = balance + console.getIntegerInput("How many more chips would you like to buy? :");

    }

    // Below this lines methods are used for testing
    // used for UNIT testing - Should not be called outside unit testing
    public void setConsole(Console console){
        this.console = console;
    }
}
