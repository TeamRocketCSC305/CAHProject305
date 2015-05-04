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

        if(topCard == null) {

            topCard = newCard;

            lastCard = topCard;

        }

        else{

            newCard.setNext(topCard);

            topCard = newCard;

        }

        size++;

    }

    public Card takeTop() {  //gets top card, and remove it from the deck

        if (size > 0) {
            Card tempCard = topCard;

            if(size > 1)
                topCard = topCard.getNext();

            else{

                topCard = null;

                lastCard = null;

            }

            size--;

            return tempCard;

        }

        else
            return null;
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

        if (tempCard == topCard)
            topCard = topCard.getNext();

        else if(tempCard == lastCard){

            lastCard.getPrev().setNext(null);

            lastCard = lastCard.getPrev();

        }

        else
            tempCard.getPrev().setNext(tempCard.getNext());

        size --;
        return tempCard;
    }

    protected int getSize(){
        return size;
    }

}
