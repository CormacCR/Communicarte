package com.example.cormacclancyruiz.communicarte;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.sinch.android.rtc.SinchError;

/**
 * Created by Liam on 08/02/2017.
 */

public class Login extends BaseActivity implements SinchService.StartFailedListener {

    private final int SPEAKER = 0, ATTENDEE = 1;

    private ProgressDialog mSpinner;
    private String username, roomKey;
    private int usertype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.login);
        username = getIntent().getStringExtra("USERNAME");
        usertype = getIntent().getIntExtra("USERTYPE",ATTENDEE);
        roomKey = getIntent().getStringExtra("ROOM_KEY");
    }

    @Override
    protected void onServiceConnected() {
        getSinchServiceInterface().setStartListener(this);
    }

    @Override
    protected void onPause() {
        if (mSpinner != null) {
            mSpinner.dismiss();
        }
        super.onPause();
    }

    @Override
    public void onStartFailed(SinchError error) {
        Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
        if (mSpinner != null) {
            mSpinner.dismiss();
        }
    }

    @Override
    public void onStarted() {
        openMessagingActivity();
    }

    private void loginClicked() {

        if (!getSinchServiceInterface().isStarted()) {
            getSinchServiceInterface().startClient(username);
            showSpinner();
        } else {
            openMessagingActivity();
        }
    }

    private void openMessagingActivity() {
        Intent messagingActivity = new Intent(this, MessagingActivity.class);
        messagingActivity.putExtra("USERTYPE", usertype);
        if(usertype==ATTENDEE){ messagingActivity.putExtra("USERNAME", username); }
        messagingActivity.putExtra("ROOM_KEY", roomKey);
        startActivity(messagingActivity);
    }

    private void showSpinner() {
        mSpinner = new ProgressDialog(this);
        mSpinner.setTitle("Logging in");
        mSpinner.setMessage("Please wait...");
        mSpinner.show();
    }

}
