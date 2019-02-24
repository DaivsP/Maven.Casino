package io.zipcoder.casino;
import io.zipcoder.casino.utilities.AdvertisementForBanners;
import io.zipcoder.casino.utilities.Console;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class Banners {
    AdvertisementForBanners optionAdvertisement = new AdvertisementForBanners();
    Console console ;

    public Banners(){
        this.console = new Console(System.in, System.out);
    }


    public void getCasinoBanner(){
        printDelay( optionAdvertisement.getCasinoStr() , 1 );
    }


    public void getBlackjackBanner() {
        printDelay( optionAdvertisement.getBlackJackStr(),1 );
    }

    public void getCrapsBanner() {
        printDelay( optionAdvertisement.getCrapsStr(),1 );
    }


    public void getGoFishBanner() {
        printDelay( optionAdvertisement.getGoFishStr(), 1) ;

    }

    public void getHighLowBanner() {

        printDelay( optionAdvertisement.getHighLowStr(),1 );
    }

    public void getOutOfFundsBanner() {
        printDelay( optionAdvertisement.getOutOfFundsStr(),1 );
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
