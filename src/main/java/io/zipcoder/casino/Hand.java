
package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> myHand = new ArrayList<Card>();
    public void Hand(){}


    public void addACard(Card card){
        myHand.add(card);
    }

    public Card getACard(Integer index){
        return (Card) myHand.get(index);
    }

    public Integer getNumberOfCards(){
        return myHand.size();
    }

    public void addASetOfCards(Card[] card){
        for(Card c : card){
            myHand.add(c);
        }
    }

    public void clearHand(){
        myHand.clear();
    }

    @Override
    public String toString(){
        String results = "";
        for (Card card: myHand) {
            results += card + ", ";
        }
        return results;
    }

    public Integer getSumOfHand() {
        Integer sumOfHand = 0;
        for (Card card: myHand) {
            sumOfHand += card.getCardValue();
        }
        return sumOfHand;
    }
}
