package io.zipcoder.casino.games.cardgames.cardutilities;

import io.zipcoder.casino.games.cardgames.cardutilities.Card;

import java.util.*;

public class CardDeck {
    private final static List<Card> DECK = new ArrayList<Card>();

    private Stack<Card> cardDeck;
    static {
        for (Card.Suit suit : Card.Suit.values()){
            Card card = new Card(null, null);
            card.createBJCardValue();
            List<Integer> listOfCardValues = card.bjCardValueList;
            Iterator<Integer> iterator = listOfCardValues.iterator();
            for (Card.Rank rank : Card.Rank.values()){
                DECK.add(new Card(rank, suit, iterator.next()));
            }
        }
    }

    public static List<Card> getDECK() {
        return DECK;
    }

    public CardDeck(){
        cardDeck = new Stack<Card>();
        cardDeck.addAll(DECK);
    }

    public void shuffle() {
        Collections.shuffle(cardDeck);
    }

    public Card dealCard(){
        return cardDeck.pop();
    }

    public Card checkNextCard(){
        return cardDeck.peek();
    }

    public int deckSize(){
        return ((Collection) cardDeck).size();
    }

    @Override
    public String toString(){
        String cards = "";
        for (Card card: cardDeck) {
            cards += card.toString() + "\n";
        }
        return cards;
    }
}