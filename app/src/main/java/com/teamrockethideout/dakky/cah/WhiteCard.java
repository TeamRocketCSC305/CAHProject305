package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class WhiteCard extends Card {

    private int refID;



    public WhiteCard(int id){
        refID = id;
    }



    public int getImg(){
        return refID;
    }
}
