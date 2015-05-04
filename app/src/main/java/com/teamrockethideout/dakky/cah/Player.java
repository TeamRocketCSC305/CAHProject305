package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class Player {

    private Deck hand;
    private Card currentWhite;
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
        System.out.println("adding");

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

    public Card getCurrentWhite() { return currentWhite; }

    public WhiteCard cycleNext(){

        if(currentWhite.getNext() != null) {

            currentWhite = currentWhite.getNext();

            return (WhiteCard) currentWhite;
        }
        else
            return (WhiteCard)currentWhite;

    }

    public WhiteCard cyclePrev(){

        if(currentWhite.getPrev() != null) {

            currentWhite = currentWhite.getPrev();

            return (WhiteCard) currentWhite;
        }
        else
            return (WhiteCard)currentWhite;

    }

}
