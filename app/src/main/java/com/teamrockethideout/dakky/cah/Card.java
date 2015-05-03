package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 * Card objects are essentially Nodes. This is the most convenient
 *  data structure for handling the cards in-game.
 */
public class Card { //dakky was here! [testing stuff]

    private Card nextCard;
    private Card prevCard;



    public Card(){
        nextCard = null;
        prevCard = null;
    }



    public Card getNext(){
        return nextCard;
    }

    public void setNext(Card someCard){
        nextCard = someCard;
    }

    public Card getPrev(){
        return prevCard;
    }

    public void setPrev(Card someCard){
        prevCard = someCard;
    }
}
