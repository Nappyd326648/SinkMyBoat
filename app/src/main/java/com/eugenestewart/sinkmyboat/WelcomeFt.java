package com.eugenestewart.sinkmyboat;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by in0418gq on 12/6/16.
 */

public class WelcomeFt extends FragmentActivity implements GoogleApiClient.OnConnectionFailedListener,View.OnClickListener{

    private static final int REQUEST_CODE_SIGN_IN = 12345;
    protected static final String FIREBASE_USER_ID_PREF_KEY = "firebase user id";
    protected static final String USE

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
