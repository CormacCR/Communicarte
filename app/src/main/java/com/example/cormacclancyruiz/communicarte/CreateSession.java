package com.example.cormacclancyruiz.communicarte;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CreateSession extends AppCompatActivity {

    private static final int KEY_LENGTH = 8;
    private String sessionKey;
    private Button generateKey;
    private TextView displayKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_session);

        displayKey = (TextView) findViewById(R.id.session_keyID);
        displayKey.setText("");

        generateKey = (Button) findViewById(R.id.generate_key);

        generateKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionKey = setSessionKey();
                displayKey.setText(sessionKey);
            }
        });

    }

    private String setSessionKey(){
        Random randomGen = new Random();
        String key = "";
        for(int i = 0; i < KEY_LENGTH; i++) {
            if((i+1)%3==0){
                key = key+"-";
            } else {
                key = key + randomGen.nextInt(10);
            }
        } return key;
    }



}
