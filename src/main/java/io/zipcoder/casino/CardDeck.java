package io.zipcoder.casino;

import java.util.*;

public class CardDeck {
    private final static List<Card> DECK = new ArrayList<Card>();
    private Stack<Card> cardDeck;

    static {
        for (Card.Suit suit : Card.Suit.values()){
            for (Card.Rank rank : Card.Rank.values()){
                DECK.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(DECK);
    }

    public CardDeck(){
        cardDeck = new Stack<Card>();
        cardDeck.addAll(DECK);
    }

    public Card dealCard(){
        return cardDeck.pop();
    }

    public Card checkNextCard(){
        return cardDeck.peek();
    }
}
