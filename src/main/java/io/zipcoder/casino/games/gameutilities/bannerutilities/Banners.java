package io.zipcoder.casino.games.gameutilities.bannerutilities;
import io.zipcoder.casino.games.gameutilities.Console;

import java.util.concurrent.TimeUnit;

public final class Banners {
    AdvertisementForBanners optionAdvertisement = new AdvertisementForBanners();
    Integer setDelay = 0;
    Console console ;


    public Banners(){
        this.console = new Console(System.in, System.out);
    }


    public void getCasinoBanner(){
        printDelay( optionAdvertisement.getCasinoStr() , setDelay );
    }


    public void getBlackjackBanner() {
        printDelay( optionAdvertisement.getBlackJackStr(),setDelay );
    }

    public void getCrapsBanner() {
        printDelay( optionAdvertisement.getCrapsStr(),setDelay );
    }


    public void getGoFishBanner() {
        printDelay( optionAdvertisement.getGoFishStr(), setDelay) ;

    }

    public void getHighLowBanner() {

        printDelay( optionAdvertisement.getHighLowStr(),setDelay );
    }

    public void getOutOfFundsBanner() {
        printDelay( optionAdvertisement.getOutOfFundsStr(),setDelay );
    }


    public void printDelay(String message, Integer time){
        for (int i = 0; i < message.length(); i++) {
            console.print( String.valueOf(message.charAt(i)) );
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    // Below this lines methods are used for testing
    // used for UNIT testing - Should not be called outside unit testing
    public void setConsole(Console console){
        this.console = console;
    }
}
