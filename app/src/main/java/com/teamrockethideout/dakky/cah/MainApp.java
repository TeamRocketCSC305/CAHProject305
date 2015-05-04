package com.teamrockethideout.dakky.cah;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;


public class MainApp extends Activity implements View.OnClickListener{

    private ViewAnimator viewAnimator;
    private float lastY;
    private boolean hostingGame;
    private String playerName;
    private GamePlay theGame;


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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_app_main);
        viewAnimator = (ViewAnimator) findViewById(R.id.viewAnimator);
        final Animation inAnim = AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        final Animation outAnim = AnimationUtils.loadAnimation(this,android.R.anim.fade_out);

        hostingGame = false;

        viewAnimator.setInAnimation(inAnim);
        viewAnimator.setOutAnimation(outAnim);
        viewAnimator.setBackgroundColor(000000);


        ((Button)findViewById(R.id.joinGamesButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.quickHostButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.customGameButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.cancelCustomButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.startButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.passwordToggle)).setOnClickListener(this);
        ((Button)findViewById(R.id.nameSetButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.gameJoinButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.cancelJoinButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.beginGameButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.leaveLobbyButton)).setOnClickListener(this);
    }

    // Using the following method, we will handle all screen swaps.
    public boolean onTouchEvent(MotionEvent touchevent) {
        return false;
    }

    @Override
    /**
     * Any interaction with buttons will take place here.
     * Buttons are labelled according to function.
     *
     *
     * For sake of reference:
     * screen 0 is the opening menu.
     * screen 1 is the custom game setup menu.
     * screen 2 is the game join menu
     * screen 3 is the name set screen
     * screen 4 is the game lobby
     * screen 5 is game play screen
     *
     * -Dakky
     */
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.joinGamesButton:  //For joining a pre-existing game

                hostingGame = false;

                viewAnimator.setDisplayedChild(2);

                break;

            case R.id.quickHostButton:  //For hosting a game with default setup

                hostingGame = true;

                viewAnimator.setDisplayedChild(3);

                break;

            case R.id.customGameButton: //For hosting a game with settable options

                hostingGame = true;

                viewAnimator.setDisplayedChild(1);

                break;

            case R.id.cancelCustomButton:   //To cancel customising a game and return to main menu

                viewAnimator.setDisplayedChild(0);

                break;

            case R.id.startButton:  //To submit selected options and go on to se the host player's name

                viewAnimator.setDisplayedChild(3);

                break;

            case R.id.cancelJoinButton: //To cancel selecting a game to join

                viewAnimator.setDisplayedChild(0);

                break;

            case R.id.gameJoinButton:   //To join a game once one has been selected

                viewAnimator.setDisplayedChild(3);

                break;

            case R.id.beginGameButton:  //To start a hosted game (host only), once enough players have joined

                viewAnimator.setDisplayedChild(5);

                break;

            case R.id.leaveLobbyButton: //To leave a game that has not yet started

                viewAnimator.setDisplayedChild(0);

                break;


            case R.id.nameSetButton:    //To submit the input to the name input box as the player ID

                Button nameButton = ((Button)findViewById(R.id.beginGameButton));

                if(!hostingGame){

                    nameButton.setClickable(false);

                    nameButton.setEnabled(false);

                    nameButton.setText("Waiting To Start");

                }

                else{

                    nameButton.setClickable(true);

                    nameButton.setEnabled(true);

                    nameButton.setText("Start Game");

                }

                String enteredText = ((EditText)findViewById(R.id.playerNameEntry)).getText().toString();

                if(stringPass(enteredText)) {

                    playerName = enteredText;

                    ((TextView)findViewById(R.id.playerNameDisplay)).setText(playerName);

                    ((ImageView)findViewById(R.id.whiteCard)).setImageResource(whites[(int)(Math.random() * 62)]);
                    ((ImageView)findViewById(R.id.blackCard)).setImageResource(blacks[(int)(Math.random() * 15)]);

//                    try {
//
//                        FileOutputStream fos = openFileOutput("whiteCardsArray", Context.MODE_PRIVATE);
//
//                        for(int i = 0; i < 62; i++) {
//                            fos.write((String.valueOf(whites[i]) + " ").getBytes());
//                        }
//
//                        fos.write(("\n").getBytes());
//
//                        for(int i = 0; i < 15; i++){
//                            fos.write((String.valueOf(blacks[i]) + " ").getBytes());
//                        }
//
//                        fos.close();
//
//                    } catch (Exception e) {
//
//                        e.printStackTrace();
//
//                    }

                    (findViewById(R.id.whiteCard)).setBackground(null);

                    (findViewById(R.id.whiteCard)).setEnabled(true);

                    (findViewById(R.id.blackCard)).setBackground(null);

                    (findViewById(R.id.blackCard)).setEnabled(true);

                    ((TextView)findViewById(R.id.setTextNotif)).setText(null);

                    viewAnimator.setDisplayedChild(4);

                }

                else {

                    ((TextView)findViewById(R.id.setTextNotif)).setText("Special Characters . , = + * - ! @ \" \' / \\ not allowed.");

                }


                break;

        }

    }

    /**
     * For sake of reference:
     * screen 0 is the opening menu.
     * screen 1 is the custom game setup menu.
     * screen 2 is the game join menu
     * screen 3 is the name set screen
     * screen 4 is the game lobby
     * screen 5 is game play screen
     */
    public void onBackPressed() {
        switch (viewAnimator.getDisplayedChild()) {
            case 5:

                viewAnimator.setDisplayedChild(4);

                break;

            case 4:

                viewAnimator.setDisplayedChild(2);

                break;

            case 3:

                viewAnimator.setDisplayedChild(0);

                break;

            case 2:

                viewAnimator.setDisplayedChild(0);

                break;

            case 1:

                viewAnimator.setDisplayedChild(0);

                break;

            case 0:

            default:

            super.onBackPressed();
        }
    }

    private boolean stringPass(String checkedText){

        boolean passes = true;

        String[] bannedChars = {".", ",", "=", "+", "*", "-", "!", "@", "\"", "\'", "/", "\\"};

        int charNum = 0;

        while(passes && charNum < bannedChars.length) {

            if(checkedText.contains(bannedChars[charNum]))

                passes = false;

            charNum++;

        }

        return passes;

    }

}
