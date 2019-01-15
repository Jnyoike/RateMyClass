package com.example.demouser.ratemyclass;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class WelcomePage extends AppCompatActivity {
    Intent intent;
    FeedbackRepository repo;
    String department, level, courseID;
    ArrayAdapter<String> departmentAdapter;
    ArrayAdapter<String> levelAdapter;
    ArrayAdapter<String> courseIDAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        // Find spinners
        final Spinner departmentSpin = (Spinner) findViewById(R.id.departmentDrop);
        final Spinner levelSpin = (Spinner) findViewById(R.id.courseLevelDrop);
        final Spinner courseIDSpin = (Spinner) findViewById(R.id.courseIDDrop);


        // Set department adapter
        departmentAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        levelAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        courseIDAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);

        // Set adapters pt2
        departmentSpin.setAdapter(departmentAdapter);
        levelSpin.setAdapter(levelAdapter);
        courseIDSpin.setAdapter(courseIDAdapter);

        // Create repo and do the rest
        repo = new FeedbackRepository(getApplication());
        addCourses();
        repo.getCourseDepartments().observe(this, new Observer<List<String>>() {

            @Override
            public void onChanged(@Nullable List<String> departments) {
                departmentAdapter.clear();
                departmentAdapter.addAll(departments);
                departmentAdapter.notifyDataSetChanged();
            }
        });

        AdapterView.OnItemSelectedListener departmentListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department = parent.getItemAtPosition(position).toString();
                repo.getCourseLevels(department);}

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }};

        AdapterView.OnItemSelectedListener levelListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                level = parent.getItemAtPosition(position).toString(); }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }};

        AdapterView.OnItemSelectedListener courseIDListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                courseID = parent.getItemAtPosition(position).toString(); }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }};


    }

    public void addCourses() {
        CourseInfo course1 = new CourseInfo("CSC 102", "How the Internet Works",
                "100", "Computer Science");
        CourseInfo course2 = new CourseInfo("CSC 103", "How Computers Work",
                "100", "Computer Science");
        CourseInfo course3 = new CourseInfo("CSC 252", "Algorithms",
                "200", "Computer Science");
        CourseInfo course4 = new CourseInfo("MTH 111", "Calculus I",
                "100", "Mathematics");
        CourseInfo course5 = new CourseInfo("MUS 325", "Writing About Music",
                "300", "Music");

        List<CourseInfo> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);

        repo.insertCourse(course1);
        repo.insertCourse(course2);
        repo.insertCourse(course3);
        repo.insertCourse(course4);
        repo.insertCourse(course5);


    }

    public void submit(View view) {
        intent = new Intent(this, FeedbackDisplay.class);
        startActivity(intent);
    }

}
