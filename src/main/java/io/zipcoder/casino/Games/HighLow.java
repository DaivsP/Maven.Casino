package io.zipcoder.casino.Games;
import io.zipcoder.casino.Balance;
import io.zipcoder.casino.Banners;
import io.zipcoder.casino.Hand;


public class HighLow extends CardGames implements FunGame {
    private io.zipcoder.casino.Person.Player highLowPlayer;

    Hand hand;


    // Use funDealer

    public HighLow()
    {
    }


  //  public void play(Balance balance) {
  public void play() {
        Banners banners = new Banners();
        banners.getHighLowBanner();
       /*while(havingFun)
        {
            if youLose
                havingFun =false
                break;
        }*/
       // balance.setBalance(balance.getBalance()-100);

    }

    public void updateScore() {
    }
}
