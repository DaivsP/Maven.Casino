
package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Comparator;

public class Hand implements Comparator {

    private ArrayList myHand = new ArrayList<Card>();
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


    public int compare(Object o1, Object o2) {

        return 0;
    }
}
