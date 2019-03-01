
package io.zipcoder.casino.games.cardgames.cardutilities;

import io.zipcoder.casino.games.cardgames.cardutilities.Card;

import java.util.*;

public class Hand  {


    private List<Card> myHand = new ArrayList<Card>();
//    protected void Hand(){}

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
        int acesCounter = 0;

        for (Card card: myHand) {
            if (card.getRank() == Card.Rank.ACE){
                acesCounter++;
            }
            sumOfHand += card.getCardValue();
            while (sumOfHand > 21 && acesCounter > 0){
                sumOfHand -= 10;
                acesCounter--;
            }
        }
        return sumOfHand;
    }


    public void sort(){
        Collections.sort(myHand);
    }

    public void removeACard(Card card){
        myHand.remove(card);
    }

    public boolean isEmpty() {
        return myHand.isEmpty();
    }
    public List<Card> removeDuplicates(){
        Set<Card> set = new HashSet<>(myHand);
        myHand.clear();
        myHand.addAll(set);
        return myHand;
    }
}

