
package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.List;

public class Hand {


    private List<Card> myHand = new ArrayList<Card>();
    protected void Hand(){}

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

    //Needs Card Value when constructing cards
    // or will throw NULL pointer exception
    @Override
    public String toString(){
        if(myHand.size() > 0) {
            String results = getACard(0).toString();
            for (int i = 1; i < myHand.size(); i++) {
                results += ", " + getACard(i);
            }
            return results;
        }
        return null;
    }

    public Integer getSumOfHand() {
        Integer sumOfHand = 0;

        for (Card card: myHand) {
            sumOfHand += card.getCardValue();
        }
        return sumOfHand;
    }

    public void removeACard(Card card){
        myHand.remove(card);
    }

    public boolean isEmpty() {
        return myHand.isEmpty();
    }
}

