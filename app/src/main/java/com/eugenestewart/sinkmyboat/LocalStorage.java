package com.eugenestewart.sinkmyboat;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by nappy on 12/6/2016.
 */

public class LocalStorage {

    private static final String USERNAME_KEY = "username";
    private static final String FIREBAS_KEY = "firebase key";

    private Context context;

    LocalStorage(Context context){
        this.context = context;
    }
    protected void writeUsername(String username){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString(USERNAME_KEY, username).apply();
    }
    protected String fetchUsername(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(USERNAME_KEY,null);
    }

    public String getFirebasKey() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString( FIREBAS_KEY, null);
    }
    public void writeFirebaseKey(String key){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString(FIREBAS_KEY,key).apply();
    }

}
