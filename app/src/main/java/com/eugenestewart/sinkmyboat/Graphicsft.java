package com.eugenestewart.sinkmyboat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by nappy on 12/11/2016.
 */

public class Graphicsft extends View {

    final static String TAG = "Graphicsft";
    int height = 1400 ;
    int width = 1300;

    int numberofXsquares = 9;
    int numberofYsquares = 9;

    float squareWidth = width/numberofXsquares;
    float squareHeight = height/numberofYsquares;

    int [][] imageResources;

    Paint linePaint;

    public Graphicsft(Context context){
        super(context);
        imageResources = new int[numberofXsquares][numberofYsquares];
        linePaint = new Paint();
        linePaint.setColor(Color.BLUE);
    }

    public  void  setImage(int x,int y,int resource){
        if(x >= numberofXsquares||y >=numberofYsquares){
            Log.w(TAG, "x, y is outside grid " + x + ", "+ y);
            return;
        }
        imageResources[x][y]= resource;
    }

    public void setAllImages(int resource){
        for(int x= 0; x < numberofXsquares; x++){
            for (int y =0; y < numberofYsquares; y++ ){
                imageResources[x][y]= resource;
            }
        }
    }
    @Override
    public void onDraw(Canvas canvas){

        int squareWidth = width/numberofXsquares;
        int squareHeight = height/numberofYsquares;

        for (int x = 0; x < numberofXsquares; x++ ){
            for (int y = 0; y < numberofYsquares; y++){
                Bitmap bitmap = createBitmap(imageResources[x][y]);
                canvas.drawBitmap(bitmap,x*squareWidth,y*squareHeight,null);
            }
        }

        for (int x= 0; x<= width; x +=squareWidth){
            canvas.drawLine(x,0,x,height,linePaint);
        }
        for(int y = 0; y<= height; y+=squareHeight){
            canvas.drawLine(0,y,width,y,linePaint);
        }
    }
    private Bitmap createBitmap(int resourceId){

        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(),resourceId);
        Bitmap scaled = Bitmap.createScaledBitmap(bitmap,(int)squareWidth, (int)squareHeight,true );
        return scaled;
    }
    public Square whichSquareTapped(float x, float y){
        //out of bounds test
        if (x> width||y>height){
            return null;
        }
        int xLoc = (int) Math.floor(x/squareWidth);
        int yLoc = (int) Math.floor(x/squareHeight);

        Log.d(TAG, "x= "+ x + " y = " + "xLoc " + xLoc + " yLoc"+ yLoc);
        return new Square(xLoc,yLoc);
    }

}
