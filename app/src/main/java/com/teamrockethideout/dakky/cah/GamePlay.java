package com.teamrockethideout.dakky.cah;



/**
 * Created by Jason on 4/30/15.
 */
public class GamePlay {

    private Player[] players;
    private Player self;
    private Deck whiteDeck, blackDeck, usedWhites, usedBlacks;
    private int timeLimit, handSize;
    private String gameName;
    private String pass;

    int[] whites = {R.drawable.white00001, R.drawable.white00002,
            R.drawable.white00003, R.drawable.white00004, R.drawable.white00005,
            R.drawable.white00006, R.drawable.white00007, R.drawable.white00008,
            R.drawable.white00009, R.drawable.white00010, R.drawable.white00011,
            R.drawable.white00012, R.drawable.white00013, R.drawable.white00014,
            R.drawable.white00015, R.drawable.white00016, R.drawable.white00017,
            R.drawable.white00018, R.drawable.white00019, R.drawable.white00020,
            R.drawable.white00021, R.drawable.white00022, R.drawable.white00023,
            R.drawable.white00024, R.drawable.white00025, R.drawable.white00026,
            R.drawable.white00027, R.drawable.white00028, R.drawable.white00029,
            R.drawable.white00030, R.drawable.white00031, R.drawable.white00032,
            R.drawable.white00033, R.drawable.white00034, R.drawable.white00035,
            R.drawable.white00036, R.drawable.white00037, R.drawable.white00038,
            R.drawable.white00039, R.drawable.white00040, R.drawable.white00041,
            R.drawable.white00042, R.drawable.white00043, R.drawable.white00044,
            R.drawable.white00045, R.drawable.white00046, R.drawable.white00047,
            R.drawable.white00048, R.drawable.white00049, R.drawable.white00050,
            R.drawable.white00051, R.drawable.white00052, R.drawable.white00053,
            R.drawable.white00054, R.drawable.white00055, R.drawable.white00056,
            R.drawable.white00057, R.drawable.white00058, R.drawable.white00059,
            R.drawable.white00060, R.drawable.white00061, R.drawable.white00062};

    int[] blacks = {R.drawable.black00001, R.drawable.black00002,
            R.drawable.black00003, R.drawable.black00004, R.drawable.black00005,
            R.drawable.black00006, R.drawable.black00007, R.drawable.black00008,
            R.drawable.black00009, R.drawable.black00010, R.drawable.black00011,
            R.drawable.black00012, R.drawable.black00013, R.drawable.black00014,
            R.drawable.black00015};



    public GamePlay(){}

    public void setCzar(Player player){}

    public void combineDecks(Deck first, Deck second){  //recieves two decks to be combined

        while(second.getSize()>0){      //while there are cards in the second deck

            first.addCard(second.takeTop());    //Take them off the top and add them to the first

        }

    }

    public void setupGame(){

        players = {new Player()};

        handSize = 7;

        pass = null;

        gameName = "CAH";

        whiteDeck = new Deck();

        for(int i = 0; i < whites.length; i++){

            whiteDeck.addCard(new WhiteCard(whites[i]));

        }

        blackDeck = new Deck();

        for(int i = 0; i < blacks.length; i++){

            blackDeck.addCard(new BlackCard(blacks[i]));

        }

        whiteDeck = shuffle(whiteDeck);
        blackDeck = shuffle(blackDeck);

    }

    public void  setupGame(int maxPlayers, int handSize, String password, String gameName, boolean[] decks){

    }

    public void initiateGame(){

    }

    public Deck shuffle(Deck toBeShuffled){

        Card temp = toBeShuffled.takeRand(); //Start by taking a random card
        int deckSize = toBeShuffled.getSize(); //Get the size of the starting deck

        Deck shuffled = new Deck(temp); //Create new deck with the random card as the top

        for (int i = 0; i < deckSize; i--){    //as long as it original deck has cards
            temp = toBeShuffled.takeRand(); // take a random card

            shuffled.addCard(temp); // and add it to our new deck
        }
        return shuffled;    // then return our shuffled deck
    }

    public void deal(){

        for(int i = 0; i < players.length; i++){

            if(players[i] != null){

                if(players[i].getHand() == null)
                    players[i].newHand(new Deck());

                while(players[i].getHand().getSize() < handSize){

                    players[i].getHand().addCard(whiteDeck.takeTop());

                }

            }

        }
    }

    public void dealTo(Player dealtTo, int cardsDealt){

        for(int i = 0; i < cardsDealt; i++){

            dealtTo.getHand().addCard(whiteDeck.takeTop());

        }
    }
}
