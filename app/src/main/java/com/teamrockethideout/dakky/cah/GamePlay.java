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

    public void combineDecks(Deck first, Deck second){  //recieves two decks to be combined
        second = shuffle(second);        //so the second deck gets shuffled

        while(second.getSize()>0){      //while there are cards in the second deck
            first.addCard(second.takeTop());    //Take them off the top and add them to the first
        }

    }

    public Deck shuffle( Deck  tobeShuffled){

        Card temp = tobeShuffled.takeRand();
        int deckSize = tobeShuffled.getSize();

        Deck shuffled= new Deck(temp);

        for (int i=0;i < deckSize;){
            temp = tobeShuffled.takeRand();

            shuffled.addCard(temp);

            deckSize--;
        }
        return shuffled;
    }

    public void deal(){}

    public void dealTo(Player dealtTo, int cardsDealt){}
}
