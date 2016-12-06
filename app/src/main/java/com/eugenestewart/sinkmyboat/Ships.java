package com.eugenestewart.sinkmyboat;

import android.graphics.Point;

import java.util.LinkedList;

/**
 * Created by nappy on 12/4/2016.
 */

public class Ships {

    int size;
    LinkedList<Point> coordinates = new LinkedList<>();
    boolean hit;
    boolean sunk

    public LinkedList<Point> getCoordinates() {
        return coordinates;
    }

    public int getSize() {
        return size;
    }
}
