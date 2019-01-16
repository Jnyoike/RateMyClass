package com.example.demouser.ratemyclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class FeedbackForm extends AppCompatActivity {
    String semester, year, midterm, finalF;
    FeedbackRepository rep = new FeedbackRepository(getApplication());
    private String  courseId;
    private final String TAG = "tage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);
        Intent intent = getIntent();
        courseId = intent.getStringExtra(FeedbackDisplay.KEY);
        // Spinners
        Spinner semesterSpin = (Spinner) findViewById(R.id.semester);
        Spinner yearSpin = (Spinner) findViewById(R.id.year);
        Spinner midtermSpin = (Spinner) findViewById(R.id.midtermInput);
        Spinner finalSpin = (Spinner) findViewById(R.id.finalInput);

        // Adapters
        ArrayAdapter<CharSequence> semAdapter = ArrayAdapter.createFromResource(
                this, R.array.Semesters, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(
                this, R.array.Years, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> examAdapter = ArrayAdapter.createFromResource(
                this, R.array.ExamFormats, android.R.layout.simple_spinner_item);


        // Connect adapter to spinner
        semAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        examAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Connect adapter to spinner pt2
        semesterSpin.setAdapter(semAdapter);
        yearSpin.setAdapter(yearAdapter);
        midtermSpin.setAdapter(examAdapter);
        finalSpin.setAdapter(examAdapter);

        // LISTEN
        semesterSpin.setOnItemSelectedListener(semesterListener);
        yearSpin.setOnItemSelectedListener(yearListener);
        midtermSpin.setOnItemSelectedListener(midtermListener);
        finalSpin.setOnItemSelectedListener(finalListener);
    }

    // Listeners
    public AdapterView.OnItemSelectedListener semesterListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            semester = parent.getItemAtPosition(position).toString(); }

        @Override
        public void onNothingSelected(AdapterView<?> parent) { }};

    public AdapterView.OnItemSelectedListener yearListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            year = parent.getItemAtPosition(position).toString(); }

        @Override
        public void onNothingSelected(AdapterView<?> parent) { }};

    public AdapterView.OnItemSelectedListener midtermListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            midterm = parent.getItemAtPosition(position).toString(); }

        @Override
        public void onNothingSelected(AdapterView<?> parent) { }};

    public AdapterView.OnItemSelectedListener finalListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            finalF = parent.getItemAtPosition(position).toString(); }

        @Override
        public void onNothingSelected(AdapterView<?> parent) { }};

    // Take Info to data base
    public void feedbackSubmit(View view){
        String courseID = courseId;
        EditText prof = (EditText) findViewById(R.id.Q1Answer);
        String profString = prof.getText().toString();

        EditText hours = (EditText) findViewById(R.id.Q3Answer);
        String hoursString = hours.getText().toString();

        //EditText semester = (EditText) findViewById(R.id.Q1Answer);
        String semesterString = semester + " " + year;

        EditText quizzes = (EditText) findViewById(R.id.quizzesAnswer);
        String quizzesString = quizzes.getText().toString();

        //EditText midterm = (EditText) findViewById(R.id.Q1Answer);
        String midtermString = midterm;

        //EditText final = (EditText) findViewById(R.id.Q1Answer);
        String finalString = finalF;

        EditText feedback = (EditText) findViewById(R.id.comments);
        String feedbackString = feedback.getText().toString();

        Log.i(TAG, courseID);
        rep.insert(new FeedbackClass(profString, hoursString, semesterString, quizzesString, midtermString, finalString,
                feedbackString, courseID));

        finish();
    }

}
