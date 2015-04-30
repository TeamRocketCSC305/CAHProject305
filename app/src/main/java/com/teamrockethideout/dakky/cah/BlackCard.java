package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class BlackCard extends Card {

    private int preDraw;
    private String refID;
    private int reqWhites;
    private boolean multi;



    public BlackCard(){}



    public int getPreDraw(){
        return preDraw;
    }

    public String getImg(){
        return refID;
    }

    public boolean isMulti(){
        return multi;
    }

    public int getWhiteNum(){
        return reqWhites;
    }
}
