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
        shuffle(first);

    }

    public Deck shuffle( Deck  tobeShuffled){

        Card temp;
        Card first = tobeShuffled.getFirst();
        int deckSize = tobeShuffled.getSize();

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
