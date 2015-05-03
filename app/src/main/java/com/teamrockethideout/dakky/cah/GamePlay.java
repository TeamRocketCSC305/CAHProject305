package com.teamrockethideout.dakky.cah;

import android.widget.Button;

/**
 * Created by Jason on 4/30/15.
 */
public class GamePlay {

    private Player self;
    private Button nextCard, prevCard;
    private Card White, nextWhite, prevWhite, Black;
    private Deck whiteDeck, blackDeck;
    private int timeLimit;



    public GamePlay(){}



    //public void update(){}   we only take actions when buttons are pressed

    public void setCzar(Player player){}

    //public void paint(){}   silly jason, no need for paint with XML layouts

    public void combineDecks(){}

    public void shuffle(){}

    public void deal(){}

    public void dealTo(Player dealtTo, int cardsDealt){}
}
