
package io.zipcoder.casino;

import java.util.ArrayList;

public class Hand {

    private ArrayList myHand = new ArrayList<Card>();

    public Hand(){}


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

    public void removeACard(Card card){
        myHand.remove(card);
    }

}

