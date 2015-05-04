package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class BlackCard extends Card {

    private int preDraw;
    private int refID;
    private int reqWhites;
    private boolean multi;



    public BlackCard(){ //blank useless black card
        preDraw = 0;
        refID = 0;
        reqWhites = 1;
        multi = false;
    }

    public BlackCard(int id){
        preDraw = 0;
        refID = id;
        reqWhites = 1;
        multi = false;
    }

    public BlackCard(int id, int draw, int whites){  //an actual card we can use
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
