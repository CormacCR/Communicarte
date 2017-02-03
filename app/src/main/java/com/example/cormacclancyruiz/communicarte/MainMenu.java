package com.example.cormacclancyruiz.communicarte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;


public class MainMenu extends AppCompatActivity {

    Button createSession;
    Button joinSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        createSession = (Button) findViewById(R.id.create_session);
        joinSession = (Button) findViewById(R.id.join_session);

        createSession.setOnClickListener(new View.OnClickListener(){
              public void onClick(View v){
                  createSession(v);
              }
        });

        joinSession.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v1){
                joinSession(v1);
            }
        });

    }

    protected void createSession (View view){
        Intent createSessionPage = new Intent(this,CreateSession.class);
        startActivity(createSessionPage);
    }

    protected void joinSession (View view){
        Intent joinSessionPage = new Intent(this,JoinSession.class);
        startActivity(joinSessionPage);
    }


}
