package io.zipcoder.casino.Games;
import io.zipcoder.casino.Banners;
import io.zipcoder.casino.CardDeck;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Person.FunDealer;
import io.zipcoder.casino.Person.HiLowPlayer;
import io.zipcoder.casino.utilities.Console;


public class HighLow extends CardGames implements FunGame {

    private HiLowPlayer player ;
    private FunDealer dealer;
    private CardDeck cardDeck;

    private Console console ;

    private Integer score;
    private Hand playerHand ;
    private Hand dealerHand ;

    public HighLow()
    {
        playerHand = new Hand();
        dealerHand = new Hand();
        player = new HiLowPlayer(null, 0 );
        dealer = new FunDealer(0);
        cardDeck = new CardDeck();
        console = new Console(System.in, System.out);
        cardDeck.shuffle();
        this.score = 0;
    }


  public void play() {
        Banners banners = new Banners();
        banners.getHighLowBanner();
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

            console.print("Your current card : ");
            console.println(playerCard.toString());
            String userGuess = console.getStringInput("Do you think the next card will be (H)igher (L)ower or the (S)ame.  : ") ;
            if("E".equals(userGuess.toUpperCase())){
                break;
            }
            else if(!win(userGuess)){
                lives--;
                console.println("WRONG: Next card was :" + dealerCard);
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
        if("E".equals(userGuess.toUpperCase()) && higherCard == 0) {
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

}
