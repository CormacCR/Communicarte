package com.example.cormacclancyruiz.communicarte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class JoinSession extends AppCompatActivity {

    Button Submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_session);

        Submit = (Button) findViewById(R.id.button);
        Submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SubmitQuestion(v);
            }
        });


    }

    protected void SubmitQuestion (View view){
        Intent UserQuestionPage = new Intent(this,UserQuestion.class);
        startActivity(UserQuestionPage);
    }
}
