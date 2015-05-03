package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class Deck {

    private Card topCard,lastCard;
    private int size;



    public Deck(Card firstCard){
        topCard = firstCard;
    }



    public void addCard(Card newCard){

        if (topCard == lastCard)
            topCard.setNext(newCard);
        else{
            lastCard.setNext(newCard);
            lastCard = newCard;
        }

    }

    public Card takeTop(){  //gets top card, and remove it from the deck
        Card tempCard = topCard;
        topCard = topCard.getNext();

        return tempCard;
    }

    public Card getFirst(){  //get the top card without removing it
        return topCard;
    }


    public Card getLast(){  //gets the last cadwithoug removing it
        return lastCard;
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
