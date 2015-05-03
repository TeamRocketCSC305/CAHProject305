package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class Deck {

    private Card topCard,lastCard;
    private int size;



    public Deck(){
        topCard = null;
        size = 0;
    }

    public Deck(Card firstCard){
        topCard = firstCard;
        size = 1;
    }



    public void addCard(Card newCard){

        if(topCard == null)
            topCard = newCard;
        else if (topCard == lastCard){
            lastCard = newCard;
            topCard.setNext(lastCard);
        }
        else{
            lastCard.setNext(newCard);
            lastCard = newCard;
        }

        size++;

    }

    public Card takeTop(){  //gets top card, and remove it from the deck
        Card tempCard = topCard;
        topCard = topCard.getNext();

        size--;

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

    protected int getSize(){
        return size;
    }

}
