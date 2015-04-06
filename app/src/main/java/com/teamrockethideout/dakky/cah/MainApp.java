package com.teamrockethideout.dakky.cah;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewAnimator;


public class MainApp extends Activity implements View.OnClickListener{

    private ViewAnimator viewAnimator;
    private float lastY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_app_main);
        viewAnimator = (ViewAnimator) findViewById(R.id.viewAnimator);
        final Animation inAnim = AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        final Animation outAnim = AnimationUtils.loadAnimation(this,android.R.anim.fade_out);

        viewAnimator.setInAnimation(inAnim);
        viewAnimator.setOutAnimation(outAnim);
        viewAnimator.setBackgroundColor(000000);


        ((Button)findViewById(R.id.joinButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.customGameButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.cancelButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.passwordToggle)).setOnClickListener(this);
    }

    // Using the following method, we will handle all screen swaps.
    public boolean onTouchEvent(MotionEvent touchevent) {
    return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.joinButton:
                viewAnimator.setDisplayedChild(2);
                break;

            case R.id.customGameButton:
                viewAnimator.setDisplayedChild(1);
                break;

            case R.id.cancelButton:
                viewAnimator.setDisplayedChild(0);
                break;

            case R.id.beginButton:
                viewAnimator.setDisplayedChild(2);

        }
    }
}
