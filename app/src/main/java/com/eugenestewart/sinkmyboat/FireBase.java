package com.eugenestewart.sinkmyboat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by nappy on 12/6/2016.
 */

public class FireBase {

    DatabaseReference db;
    LocalStorage localStorage;

    public FireBase(LocalStorage localStorage){
        this.localStorage = localStorage;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        db = database.getReference();
    }
}
