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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FrameLayout mFrame;


    private int screenPixelsX;
    private int screenPixelsY;
    private int aspect;

    public int maxX;
    public int maxY;

    public int gameState = 1;

    public int [][] ShipCoornates = new int [9][9]  ;
    Random rnd = new Random();
    public  boolean hit;
   public int aX;
   public int aY;

    private FireBase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrame = (FrameLayout) findViewById(R.id.activity_main);

        final Graphicsft graphicsft = new Graphicsft(this);


        graphicsft.setAllImages(R.drawable.water);
        mFrame.addView(graphicsft);
        for (int x = 0; x >= 9; x++) {
            for (int y = 0; y >= 9; y++) {
                ShipCoornates[x][y] = 0;
            }
        }
        //randomly placeing ships
        int x1 = rnd.nextInt(9);
        int y1 = rnd.nextInt(9);
        int uporleft = rnd.nextInt(2);
        if (ShipCoornates[x1][y1]== 0) {
            ShipCoornates[x1][y1] = 1;
            if (uporleft == 0) {
                if (x1 == 0 || x1 == 1 || x1 == 2 || x1 == 3 || x1 == 4 || x1 == 5) {
                    ShipCoornates[x1 + 1][y1] = 1;
                    ShipCoornates[x1 + 2][y1] = 1;
                    ShipCoornates[x1 + 3][y1] = 1;
                    ShipCoornates[x1 + 4][y1] = 1;

                } else if (x1 == 9 || x1 == 8 || x1 == 7 || x1 == 6) {
                    ShipCoornates[x1 - 1][y1] = 1;
                    ShipCoornates[x1 - 2][y1] = 1;
                    ShipCoornates[x1 - 3][y1] = 1;
                    ShipCoornates[x1 - 4][y1] = 1;
                }

            } else if (uporleft == 1) {
                if (y1 == 0 || y1 == 1 || y1 == 2 || y1 == 3 || y1 == 4 || y1 == 5) {
                    ShipCoornates[x1][y1 + 1] = 1;
                    ShipCoornates[x1][y1 + 2] = 1;
                    ShipCoornates[x1][y1 + 3] = 1;
                    ShipCoornates[x1][y1 + 4] = 1;

                } else if (x1 == 9 || x1 == 8 || x1 == 7 || x1 == 6) {
                    ShipCoornates[x1][y1 - 1] = 1;
                    ShipCoornates[x1][y1 - 2] = 1;
                    ShipCoornates[x1][y1 - 3] = 1;
                    ShipCoornates[x1][y1 - 4] = 1;
                }

            }
        }

        x1 = rnd.nextInt(9);
        y1 = rnd.nextInt(9);
        uporleft = rnd.nextInt(2);
        if (ShipCoornates[x1][y1]== 0) {
            ShipCoornates[x1][y1] = 1;
            if (uporleft == 0) {
                if (x1 == 0 || x1 == 1 || x1 == 2 || x1 == 3 || x1 == 4 || x1 == 5) {
                    ShipCoornates[x1 + 1][y1] = 1;
                    ShipCoornates[x1 + 2][y1] = 1;
                    ShipCoornates[x1 + 3][y1] = 1;


                } else if (x1 == 9 || x1 == 8 || x1 == 7 || x1 == 6) {
                    ShipCoornates[x1 - 1][y1] = 1;
                    ShipCoornates[x1 - 2][y1] = 1;
                    ShipCoornates[x1 - 3][y1] = 1;

                }

            } else if (uporleft == 1) {
                if (y1 == 0 || y1 == 1 || y1 == 2 || y1 == 3 || y1 == 4 || y1 == 5) {
                    ShipCoornates[x1][y1 + 1] = 1;
                    ShipCoornates[x1][y1 + 2] = 1;
                    ShipCoornates[x1][y1 + 3] = 1;


                } else if (x1 == 9 || x1 == 8 || x1 == 7 || x1 == 6) {
                    ShipCoornates[x1][y1 - 1] = 1;
                    ShipCoornates[x1][y1 - 2] = 1;
                    ShipCoornates[x1][y1 - 3] = 1;

                }

            }
        }
        x1 = rnd.nextInt(9);
        y1 = rnd.nextInt(9);
        uporleft = rnd.nextInt(2);
        if (ShipCoornates[x1][y1]== 0) {
            ShipCoornates[x1][y1] = 1;
            if (uporleft == 0) {
                if (x1 == 0 || x1 == 1 || x1 == 2 || x1 == 3 || x1 == 4 || x1 == 5) {
                    ShipCoornates[x1 + 1][y1] = 1;
                    ShipCoornates[x1 + 2][y1] = 1;


                } else if (x1 == 9 || x1 == 8 || x1 == 7 || x1 == 6) {
                    ShipCoornates[x1 - 1][y1] = 1;
                    ShipCoornates[x1 - 2][y1] = 1;

                }

            } else if (uporleft == 1) {
                if (y1 == 0 || y1 == 1 || y1 == 2 || y1 == 3 || y1 == 4 || y1 == 5) {
                    ShipCoornates[x1][y1 + 1] = 1;
                    ShipCoornates[x1][y1 + 2] = 1;


                } else if (x1 == 9 || x1 == 8 || x1 == 7 || x1 == 6) {
                    ShipCoornates[x1][y1 - 1] = 1;
                    ShipCoornates[x1][y1 - 2] = 1;

                }

            }
        }
        x1 = rnd.nextInt(9);
        y1 = rnd.nextInt(9);
        uporleft = rnd.nextInt(2);
        if (ShipCoornates[x1][y1]== 0) {
            ShipCoornates[x1][y1] = 1;
            if (uporleft == 0) {
                if (x1 == 0 || x1 == 1 || x1 == 2 || x1 == 3 || x1 == 4 || x1 == 5) {
                    ShipCoornates[x1 + 1][y1] = 1;


                } else if (x1 == 9 || x1 == 8 || x1 == 7 || x1 == 6) {
                    ShipCoornates[x1 - 1][y1] = 1;

                }

            } else if (uporleft == 1) {
                if (y1 == 0 || y1 == 1 || y1 == 2 || y1 == 3 || y1 == 4 || y1 == 5) {
                    ShipCoornates[x1][y1 + 1] = 1;


                } else if (x1 == 9 || x1 == 8 || x1 == 7 || x1 == 6) {
                    ShipCoornates[x1][y1 - 1] = 1;

                }

            }
        }
        x1 = rnd.nextInt(9);
        y1 = rnd.nextInt(9);
        uporleft = rnd.nextInt(2);
        if (ShipCoornates[x1][y1]== 0) {
            ShipCoornates[x1][y1] = 1;
            if (uporleft == 0) {
                if (x1 == 0 || x1 == 1 || x1 == 2 || x1 == 3 || x1 == 4 || x1 == 5) {
                    ShipCoornates[x1 + 1][y1] = 1;
                    ShipCoornates[x1 + 2][y1] = 1;


                } else if (x1 == 9 || x1 == 8 || x1 == 7 || x1 == 6) {
                    ShipCoornates[x1 - 1][y1] = 1;
                    ShipCoornates[x1 - 2][y1] = 1;

                }

            } else if (uporleft == 1) {
                if (y1 == 0 || y1 == 1 || y1 == 2 || y1 == 3 || y1 == 4 || y1 == 5) {
                    ShipCoornates[x1][y1 + 1] = 1;
                    ShipCoornates[x1][y1 + 2] = 1;


                } else if (x1 == 9 || x1 == 8 || x1 == 7 || x1 == 6) {
                    ShipCoornates[x1][y1 - 1] = 1;
                    ShipCoornates[x1][y1 - 2] = 1;

                }

            }
        }

        switch (gameState) {
            case 1: {

                int counter = 0;
                switch (counter) {
                    case 0: {
                        Toast.makeText(this, "touch to send an attack", Toast.LENGTH_LONG).show();
                        graphicsft.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                if (motionEvent.getAction() == motionEvent.ACTION_DOWN) {
                                    Square whichSquare = graphicsft.whichSquareTapped(motionEvent.getX(), motionEvent.getY());


                                    if (whichSquare != null) {

                                        graphicsft.setImage(whichSquare.x, whichSquare.y, R.drawable.target);

                                         aX = whichSquare.x;
                                         aY = whichSquare.y;
                                        graphicsft.invalidate();
                                        firebase.db.child("Users").child(WelcomeFt.USERS_PREFS).setValue(aX,aY);


                                    }

                                }
                                return false;
                            }
                        });
                        counter++;
                        System.out.println(counter);
                        break;
                    }
                    case 1:{
                     // get opponents attack
                        int oX;
                        int oY;

                        if (ShipCoornates[oX][oY]==1){
                            Toast.makeText(this, "You been hit!!!", Toast.LENGTH_LONG).show();
                            //Send results to firebase;
                            hit=true;
                        } else if (ShipCoornates[oX][oY]==0){
                            Toast.makeText(this, "They missed ", Toast.LENGTH_LONG).show();
                            hit=false;
                        }
                        counter++;
                        break;
                    }
                    case 2:{
                        // get results
                        boolean didihit;
                        if (didihit==true) {
                            graphicsft.setImage(aX, aY, R.drawable.redx);
                        } else if (didihit==false){
                            graphicsft.setImage(aX, aY, R.drawable.sad);

                        }
                        counter=0;
                        break;
                    }


                    default: {

                    }


                }
            }
            default: {

            }
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
