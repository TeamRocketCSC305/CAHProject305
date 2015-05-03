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

    public void combineDecks(){

    }

    public Card shuffle( Card deckHead){

        Card temp = deckHead;
        Card newhead,tail;
        int deckSize = 1;

        while (temp.hasNext()){
            temp = temp.getNext();
            deckSize ++;
        }

        temp = deckHead;


        for (int i=0 ;i < deckSize*Math.random();i++) {
            temp = temp.getNext();
        }
        if(temp != deckHead)
            temp.getPrev().setNext(temp.getNext());
        else
            deckHead = deckHead.getNext();

        deckSize--;

        newhead = temp;
        tail = temp;

        for (int i=0;i < deckSize;){
            temp = deckHead;
            for (int j=1;j < deckSize*Math.random();j++){
                temp = temp.getNext();
            }

            if(temp != deckHead)
                temp.getPrev().setNext(temp.getNext());
            else
                deckHead = deckHead.getNext();

            tail.setNext(temp);
            tail = temp;

            deckSize--;
        }
        return newhead;
    }

    public void deal(){}

    public void dealTo(Player dealtTo, int cardsDealt){}
}
