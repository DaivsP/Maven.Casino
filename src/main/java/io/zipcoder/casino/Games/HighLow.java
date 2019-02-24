package io.zipcoder.casino.Games;
import io.zipcoder.casino.Banners;
import io.zipcoder.casino.CardDeck;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Person.FunDealer;
import io.zipcoder.casino.Person.HiLowPlayer;


public class HighLow extends CardGames implements FunGame {

    //Hand hand;
    private HiLowPlayer player ;
    private FunDealer dealer;
    private CardDeck cardDeck;


    // Use funDealer if needed dealer person

    public HighLow()
    {
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        player = new HiLowPlayer(null, 0 );
        player.setHand(playerHand);
        dealer = new FunDealer(0);
        dealer.setHand(dealerHand);
        cardDeck = new CardDeck();

    }


  //  public void play(Balance balance) {
  public void play() {
        Banners banners = new Banners();
        banners.getHighLowBanner();
        Boolean havingFun = true;

        while(havingFun){
            System.out.println("In the loop");
            break;
        }


       /*while(havingFun)
        {
            if youLose
                havingFun =false
                break;
        }*/
       // balance.setBalance(balance.getBalance()-100);

    }

    public Boolean win(String userGuess){
        Boolean retVal = false;
        Integer higherCard = player.getHand().compare(player.getHand().getACard(0),dealer.getHand().getACard(0));
        if("E".equals(userGuess.toUpperCase()) && higherCard == 0) {
            //System.out.println("Next card Equals");
            retVal = true;
        }
        if("H".equals(userGuess.toUpperCase()) && higherCard == 1) {
           // System.out.println("Next Card Was Higher");
            retVal = true;
        }
        if("L".equals(userGuess.toUpperCase()) && higherCard == -1) {
           // System.out.println("Next card was Lower");
            retVal = true;
        }
        return retVal;
    }

    // not used - no score saved for high/low - Need for interface
    public void updateScore() {

    }

    // Getters only - Nothing should be setting these outside of this class
    public HiLowPlayer getHLPlayer(){
        return this.player;
    }

    public CardDeck getCardDeck(){
        return this.cardDeck;
    }

    public FunDealer getHLDealer(){
        return this.dealer;
    }

}
