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

        Card temp = tobeShuffled.takeRand(); //Start by taking a random card
        int deckSize = tobeShuffled.getSize(); //Get the size of the starting deck

        Deck shuffled= new Deck(temp); //Create new deck with the random card as the top

        for (int i=0;i < deckSize;){    //as long as it original deck has cards
            temp = tobeShuffled.takeRand(); // take a random card

            shuffled.addCard(temp); // and add it to our new deck

            deckSize--; // then decrement our count
        }
        return shuffled;    // then return our shuffled deck
    }

    public void deal(){
        int i = self.getHand().getSize();
        while(i>7){
            self.getHand().addCard(whiteDeck.takeTop());
        }
    }

    public void dealTo(Player dealtTo, int cardsDealt){
        for(int i=0;i<cardsDealt;i++){
            dealtTo.getHand().addCard(whiteDeck.takeTop());
        }
    }
}
