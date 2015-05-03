package com.teamrockethideout.dakky.cah;

import java.lang.Math;

/**
 * Created by Jason on 4/30/15.
 */
public class GamePlay {

    private Player self;
    private Button nextCard, prevCard;
    private Card White, nextWhite, prevWhite, Black;
    private Deck whiteDeck, blackDeck, usedWhites, usedBlacks;
    private int timeLimit;



    public GamePlay(){}



    public void update(){}

    public void setCzar(Player player){}

    public void paint(){}

    public void actionListener(actionEvent e){}

    public void combineDecks(Deck first, Deck second){
        Card temp = first.getLast();
        temp.setNext(second.takeTop());
        shuffle(first.takeTop());

    }

    public Deck shuffle( Deck  tobeshuffled){

        Card temp = tobeshuffled.getFirst();
        Card first = tobeshuffled.getFirst();


        int deckSize = 1;

        while (temp.hasNext()){
            temp = temp.getNext();
            deckSize ++;
        }

        temp = first;


        for (int i=0 ;i < deckSize*Math.random();i++) {
            temp = temp.getNext();
        }
        if(temp != first)
            temp.getPrev().setNext(temp.getNext());
        else
            first = first.getNext();

        deckSize--;

        Deck shuffled= new Deck(temp);

        for (int i=0;i < deckSize;){
            temp = first;
            for (int j=1;j < deckSize*Math.random();j++){
                temp = temp.getNext();
            }

            if(temp != first)
                temp.getPrev().setNext(temp.getNext());
            else
                first = first.getNext();

            shuffled.addCard(temp);

            deckSize--;
        }
        return shuffled;
    }

    public void deal(){}

    public void dealTo(Player dealtTo, int cardsDealt){}
}
