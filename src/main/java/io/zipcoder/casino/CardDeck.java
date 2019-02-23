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
        System.out.println(cardDeck.peek().toString());
        return cardDeck.pop();
    }

    public Card checkNextCard(){
        System.out.println(cardDeck.peek().toString());
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