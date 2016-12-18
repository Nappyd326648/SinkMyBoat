package com.eugenestewart.sinkmyboat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FrameLayout mFrame;


    private int screenPixelsX;
    private int screenPixelsY;
    private int aspect;

    public int maxX;
    public int maxY;

    public String  gameState = "SETSTAGE";

    public int ShipCoornates[][]=new int [10][10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrame = (FrameLayout) findViewById(R.id.activity_main);

        final Graphicsft graphicsft = new Graphicsft(this);

        graphicsft.setAllImages(R.drawable.water);
        mFrame.addView(graphicsft);
        for (int x = 0; x >= 10; x++) {
            for (int y = 0; y >= 10; y++) {
                ShipCoornates[x][y] = 0;
            }
        }

        switch (gameState) {
            case "SETSTAGE":

                int counter = 0;
                switch (counter) {
                    case 0:
                        Toast.makeText(this, "touch five squares", Toast.LENGTH_LONG);
                        graphicsft.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                if (motionEvent.getAction() == motionEvent.ACTION_DOWN) {
                                    Square whichSquare = graphicsft.whichSquareTapped(motionEvent.getX(), motionEvent.getY());

                                    if (whichSquare != null) {

                                        graphicsft.setImage(whichSquare.x, whichSquare.y, R.drawable.boat);
                                        ShipCoornates[whichSquare.x][whichSquare.y] = 1;
                                        System.out.println(whichSquare.x);
                                        System.out.println(whichSquare.y);
                                        System.out.println(ShipCoornates[whichSquare.x][whichSquare.y]);
                                        graphicsft.invalidate();
                                    }
                                }
                                return false;
                            }
                        });

                        break;
                    case 1:
                        break;

                    default:
                        break;


                }
//                graphicsft.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View view, MotionEvent motionEvent) {
//                        if (motionEvent.getAction() == motionEvent.ACTION_DOWN) {
//                            Square whichSquare = graphicsft.whichSquareTapped(motionEvent.getX(), motionEvent.getY());
//
//                            if (whichSquare != null) {
//
//                                graphicsft.setImage(whichSquare.x, whichSquare.y, R.drawable.boat);
//                                //  ShipCoornates[whichSquare.x][whichSquare.y]=1;
//                                graphicsft.invalidate();
//                            }
//                        }
//                        return false;
//                    }
//                });
//                break;

//            case "ATTACKSTAGE":
//                graphicsft.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View view, MotionEvent motionEvent) {
//                        if (motionEvent.getAction() == motionEvent.ACTION_DOWN) {
//                            Square whichSquare = graphicsft.whichSquareTapped(motionEvent.getX(), motionEvent.getY());
//
//                            if (whichSquare != null) {
//                                System.out.println(whichSquare.x);
//                                System.out.println(whichSquare.y);
//                                graphicsft.setImage(whichSquare.x, whichSquare.y, R.drawable.target);
//                                graphicsft.invalidate();
//                            }
//                        }
//                        return false;
//                    }
//                });
//                break;


            case "RESULTSTAGE":

                break;
            default:
                int x = 0;
                break;


        }
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
