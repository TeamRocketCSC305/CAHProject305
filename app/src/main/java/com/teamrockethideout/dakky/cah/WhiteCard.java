package com.teamrockethideout.dakky.cah;

/**
 * Created by Jason on 4/30/15.
 */
public class WhiteCard extends Card {

    private String refID;



    public WhiteCard( String id){
        refID = id;
    }



    public String getImg(){
        return refID;
    }
}
