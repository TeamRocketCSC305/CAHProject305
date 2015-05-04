package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class Player {

    private Deck hand;
    private String nameTag;
    private int playerID;
    private int awesomePoints;
    private boolean isCzar;



    public Player(String name, Deck newDeck){

        nameTag = name;

        awesomePoints = 0;

        hand = newDeck;

    }

    public void addToHand(Card newCard){

        hand.addCard(newCard);

    }

    public void newHand(Deck newHand){

        hand = newHand;

    }

    public void addPoint(){
        awesomePoints++;
    }

    public Deck getHand(){
        return hand;
    }

    public int getID(){
        return playerID;
    }

    public String getName(){
        return nameTag;
    }

    public void setName(String nameIn) { nameTag = nameIn; }

    public void selectWhite(){
        
    }

    public void setCzar(boolean czar){
        isCzar = czar;
    }



}
