package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class BlackCard extends Card {

    private int preDraw;
    private String refID;
    private int reqWhites;
    private boolean multi;



    public BlackCard(){
        preDraw = 0;
        refID = null;
        reqWhites = 0;
        multi = false;
    }

    public BlackCard(String id, int draw, int whites){
        preDraw = draw;
        refID = id;
        reqWhites = whites;
        multi = reqWhites > 1;
    }


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
