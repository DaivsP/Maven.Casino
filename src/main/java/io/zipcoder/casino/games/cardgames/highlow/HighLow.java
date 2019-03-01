package io.zipcoder.casino.games.cardgames.highlow;
import io.zipcoder.casino.games.interfaceutilities.GameInterface;
import io.zipcoder.casino.Person.fun.FunDealer;
import io.zipcoder.casino.games.cardgames.cardutilities.Card;
import io.zipcoder.casino.games.cardgames.cardutilities.CardDeck;
import io.zipcoder.casino.games.cardgames.cardutilities.DecorationCards;
import io.zipcoder.casino.games.cardgames.cardutilities.Hand;
import io.zipcoder.casino.games.gameutilities.Balance;
import io.zipcoder.casino.games.gameutilities.Console;
import io.zipcoder.casino.games.gameutilities.bannerutilities.Banners;


public class HighLow  implements GameInterface {


    private HiLowPlayer player ;
    private FunDealer dealer;
    private CardDeck cardDeck;

    private Console console ;

    private Integer score;
    private Hand playerHand ;
    private Hand dealerHand ;


    public HighLow(Console console)
    {
        playerHand = new Hand();
        dealerHand = new Hand();
        player = new HiLowPlayer(null, 0 );
        dealer = new FunDealer(0);
        cardDeck = new CardDeck();
        this.console = console;
        cardDeck.shuffle();
        this.score = 0;
    }


  public void play(Balance balance) {
        Banners banners = new Banners();
        banners.getHighLowBanner();

         DecorationCards decor = new DecorationCards();

        Integer lives = 3;
        console.println("Please type 'E' to exit");

        while(lives >0){
            dealerHand.clearHand();
            playerHand.clearHand();
            Card playerCard = cardDeck.dealCard();
            Card dealerCard = cardDeck.checkNextCard();
            dealerHand.addACard(dealerCard);
            playerHand.addACard(playerCard);
            player.setHand(playerHand);
            dealer.setHand(dealerHand);

            console.println("Your current card : ");
           // console.println(playerCard.toString());

            decor.drawHand(playerHand);
            console.println("");
            String userGuess = console.getStringInput("Do you think the next card will be (H)igher (L)ower or the (S)ame.  : ") ;
            if("E".equals(userGuess.toUpperCase())){
                break;
            }
            else if(!win(userGuess)){
                lives--;
                console.println("WRONG: Next card was :" );
                decor.drawHand(dealerHand);
                console.println("");
                console.println("Lives left :" + lives);

            }
            else {
               updateScore();
            }

        }
      console.println("You guessed correctly "+score+" times!" );

    }

    public Boolean win(String userGuess){
        Boolean retVal = false;
        Integer higherCard =compareRank();
        if("S".equals(userGuess.toUpperCase()) && higherCard == 0) {
            retVal = true;
        }
        if("H".equals(userGuess.toUpperCase()) && higherCard < 0) {
            retVal = true;
        }
        if("L".equals(userGuess.toUpperCase()) && higherCard > 0) {
            retVal = true;
        }
        return retVal;
    }

    public Integer compareRank(){
        return player.getHand().getACard(0).getRank().ordinal() - dealer.getHand().getACard(0).getRank().ordinal();
    }

    public void updateScore() {
        score++;
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

    // Below this lines methods are used for testing
    // used for UNIT testing - Should not be called outside unit testing
    public void setConsole(Console console){
        this.console = console;
    }

    public Integer getScore() {return this.score;};

}
