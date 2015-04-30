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
import android.widget.TextView;
import android.widget.ViewAnimator;


public class MainApp extends Activity implements View.OnClickListener{

    private ViewAnimator viewAnimator;
    private float lastY;
    private boolean hostingGame;
    private String playerName;


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

                    viewAnimator.setDisplayedChild(4);

                }

                else {

                    playerName = "fak u";

                }


                break;

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
