package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class Player {

    private Deck hand;
    private String nameTag;
    private int playerID;
    private int awesomePoints;



    public Player(){}



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

    public void selectWhite(){

    }

}
