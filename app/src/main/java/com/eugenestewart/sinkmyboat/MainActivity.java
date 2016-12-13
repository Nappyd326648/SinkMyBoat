package com.eugenestewart.sinkmyboat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout mFrame;


    private int screenPixelsX;
    private int screenPixelsY;
    private int aspect;

    public int maxX;
    public int maxY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrame = (FrameLayout) findViewById(R.id.activity_main);

        final  Graphicsft graphicsft = new Graphicsft(this);


        graphicsft.setAllImages(R.drawable.water);
        mFrame.addView(graphicsft);

        graphicsft.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent){
                if(motionEvent.getAction()==motionEvent.ACTION_DOWN){
                    Square whichSquare = graphicsft.whichSquareTapped(motionEvent.getX(),motionEvent.getY());

                    if (whichSquare!= null){
                        graphicsft.setImage(whichSquare.x,whichSquare.y,R.drawable.target);
                        graphicsft.invalidate();
                    }
                }
                return false;
            }
        });



    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        return false;
    }
    public void onWindowFocusChanged(boolean hasFocus){
        screenPixelsX = mFrame.getWidth();
        screenPixelsY = mFrame.getHeight();
        aspect = (screenPixelsY/screenPixelsX);

        maxX=screenPixelsX/60;
        maxY=screenPixelsY/60;


    }

}
