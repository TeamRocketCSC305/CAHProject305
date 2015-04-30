package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class Deck {

    private Card topCard;
    private int size;



    public Deck(){}



    public void addCard(Card newCard){
        topCard.setNext(newCard);
    }

    public Card takeTop(){
        Card tempCard = topCard;
        topCard = topCard.getNext();

        return tempCard;
    }

    public Card takeRand(){
        int rand = (int)(Math.random() * size);

        Card tempCard = topCard;

        for (int i = 0; i < rand; i++)
            tempCard = tempCard.getNext();

        if (tempCard != topCard)
            tempCard.getPrev().setNext(tempCard.getNext());
        else
            topCard = topCard.getNext();

        return tempCard;
    }

}
