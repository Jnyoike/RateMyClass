package com.example.demouser.ratemyclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FeedBackActivity extends AppCompatActivity {

    feedbackRepository rep = new feedbackRepository(getApplication());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
    }

    public void feedbackSubmit(View view){
        String courseID = "CSC 111";
        EditText prof = (EditText) findViewById(R.id.Q1Answer);
        String profString = prof.getText().toString();


        EditText hours = (EditText) findViewById(R.id.Q3Answer);
        String hoursString = hours.getText().toString();

        //EditText semester = (EditText) findViewById(R.id.Q1Answer);
        String semesterString = "Fall 2018";

        EditText quizzes = (EditText) findViewById(R.id.quizzesAnswer);
        String quizzesString = quizzes.getText().toString();

        //EditText midterm = (EditText) findViewById(R.id.Q1Answer);
        String midtermString = "In-Class";

        //EditText final = (EditText) findViewById(R.id.Q1Answer);
        String finalString = "project";

        EditText feedback = (EditText) findViewById(R.id.comments);
        String feedbackString = feedback.getText().toString();

        rep.insert(new feedbackClass(profString, hoursString, semesterString, quizzesString, midtermString, finalString,
                feedbackString, courseID));

        finish();
    }

}
