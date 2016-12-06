package com.eugenestewart.sinkmyboat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
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




        System.out.println(screenPixelsX);
        System.out.println(screenPixelsY);
        System.out.println(aspect);
        System.out.println(maxX);
        System.out.println(maxY);



    }
}
