package com.teamrockethideout.dakky.cah;

/**
 * Created by Dakky on 5/4/15.
 */
public class SingleRound {

    BlackCard blackCard;
    Object[][] playerCards;
    int submitted;
    Deck allWhites;

    public SingleRound(BlackCard card, int players){
        submitted = 0;
        blackCard = card;
        playerCards = new WhiteCard[players][2];
    }

    public void submitWhite(Player submitter, WhiteCard submittedCard){

        if(submitted < playerCards.length) {

            playerCards[submitted][0] = submitter;

            playerCards[submitted][1] = submittedCard;

            submitted++;

        }
        else{

            allWhites = new Deck();

            for(int i = 0; i < playerCards.length; i++){

                allWhites.addCard((Card)playerCards[i][1]);

            }
        }
    }



}
