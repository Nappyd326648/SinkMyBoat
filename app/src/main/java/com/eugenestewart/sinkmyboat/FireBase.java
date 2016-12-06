package com.eugenestewart.sinkmyboat;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by nappy on 12/6/2016.
 */

public class FireBase {

    DatabaseReference db;
    FirebaseDatabase fdb;
    LocalStorage localStorage;

    ArrayList<EmailAuthCredential>players;


    public FireBase(LocalStorage localStorage){
        this.localStorage = localStorage;
        fdb = FirebaseDatabase.getInstance();
        db = fdb.getReference();
    }

    public void getPlayers()
}
