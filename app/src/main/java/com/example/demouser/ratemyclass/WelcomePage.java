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
    public static final String KEY = "KEY";
    public static final String NAME_KEY = "NAME_KEY";
    Spinner levelSpin;
    Spinner courseIDSpin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        // Find spinners
        final Spinner departmentSpin = (Spinner) findViewById(R.id.departmentDrop);
        levelSpin = (Spinner) findViewById(R.id.courseLevelDrop);
        courseIDSpin = (Spinner) findViewById(R.id.courseIDDrop);


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
        //addCourses();
        repo.getCourseDepartments().observe(this, new Observer<List<String>>() {

            @Override
            public void onChanged(@Nullable List<String> departments) {
                departmentAdapter.clear();
                departmentAdapter.addAll(departments);
                departmentAdapter.notifyDataSetChanged();
            }
        });
        departmentSpin.setOnItemSelectedListener(departmentListener);
        levelSpin.setOnItemSelectedListener(levelListener);
        courseIDSpin.setOnItemSelectedListener(courseIDListener);


    }
    AdapterView.OnItemSelectedListener departmentListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            department = parent.getItemAtPosition(position).toString();
            repo.getCourseLevels(department).observe(WelcomePage.this, new Observer<List<String>>() {

                @Override
                public void onChanged(@Nullable List<String> levels) {
                    levelAdapter.clear();
                    levelAdapter.addAll(levels);
                    levelAdapter.notifyDataSetChanged();
                    Log.d(KEY, Integer.toString(levelSpin.getSelectedItemPosition()));
                    updateCourseIds(levelSpin, levelSpin.getSelectedItemPosition());

                }
            });
//            repo.getCourseIDs(level, department).observe(WelcomePage.this, new Observer<List<String>>() {
//
//                @Override
//                public void onChanged(@Nullable List<String> ids) {
//                    courseIDAdapter.clear();
//                    courseIDAdapter.addAll(ids);
//                    courseIDAdapter.notifyDataSetChanged();
//                }
//            });
//            repo.getCourseLevels(department);
//            repo.getCourseIDs(level, department);
            }

        @Override
        public void onNothingSelected(AdapterView<?> parent) { }};
    public void updateCourseIds(AdapterView<?> parent, int position) {
        if (parent.getItemAtPosition(position) != null) {
            level = parent.getItemAtPosition(position).toString();
            repo.getCourseIDs(level, department).observe(WelcomePage.this, new Observer<List<String>>() {

                @Override
                public void onChanged(@Nullable List<String> ids) {
                    courseIDAdapter.clear();
                    courseIDAdapter.addAll(ids);
                    courseIDAdapter.notifyDataSetChanged();
                    int pos = courseIDSpin.getSelectedItemPosition();
                    if (pos < 0){
                        courseID = null;
                    }else{
                    courseID = courseIDSpin.getItemAtPosition(pos).toString();}
                }
            });
        }
    }
    AdapterView.OnItemSelectedListener levelListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            level = parent.getItemAtPosition(position).toString();
//            repo.getCourseIDs(level, department).observe(WelcomePage.this, new Observer<List<String>>() {
//
//                @Override
//                public void onChanged(@Nullable List<String> ids) {
//                    courseIDAdapter.clear();
//                    courseIDAdapter.addAll(ids);
//                    courseIDAdapter.notifyDataSetChanged();
//                }
//            });
            updateCourseIds(parent, position);
//            repo.getCourseIDs(level, department);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) { }};

    AdapterView.OnItemSelectedListener courseIDListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            courseID = parent.getItemAtPosition(position).toString(); }

        @Override
        public void onNothingSelected(AdapterView<?> parent) { }};
    public void addCourses() {
//        CourseInfo course1 = new CourseInfo("CSC 102", "How the Internet Works",
//                "100", "Computer Science");
//        CourseInfo course2 = new CourseInfo("CSC 103", "How Computers Work",
//                "100", "Computer Science");
//        CourseInfo course3 = new CourseInfo("CSC 111", "Intro Computer Science through Programming",
//                "100", "Computer Science");
//        CourseInfo course4 = new CourseInfo("CSC 212", "Programming with Data Structures",
//                "200", "Computer Science");
//        CourseInfo course5 = new CourseInfo("CSC 220", "Advanced Programming Techniques",
//                "200", "Computer Science");
//        CourseInfo course6 = new CourseInfo("CSC 250", "Theoretical Foundations Computer Science",
//                "200", "Computer Science");
//        CourseInfo course7 = new CourseInfo("CSC 256", "Intelligent User Interfaces",
//                "200", "Computer Science");
//        CourseInfo course8 = new CourseInfo("CSC 262", "Operating Systems",
//                "200", "Computer Science");
//        CourseInfo course9 = new CourseInfo("CSC 270", "Digital Circuits and Systems",
//                "200", "Computer Science");
//        CourseInfo course10 = new CourseInfo("CSC 290", "Artificial Intelligence",
//                "200", "Computer Science");
//        CourseInfo course11 = new CourseInfo("CSC 330", "Database Systems",
//                "300", "Computer Science");
//        CourseInfo course12 = new CourseInfo("CSC 354", "Seminar in Music Processing",
//                "300", "Computer Science");
//        CourseInfo course13 = new CourseInfo("CSC 105", "Interactive Web Documents",
//                "100", "Computer Science");
//        CourseInfo course14 = new CourseInfo("CSC 109", "Communicating With Data",
//                "100", "Computer Science");
//        CourseInfo course15 = new CourseInfo("CSC 231", "Microprocessors and Assembly Language",
//                "200", "Computer Science");
//        CourseInfo course16 = new CourseInfo("CSC 240", "Graphics",
//                "200", "Computer Science");
//        CourseInfo course17 = new CourseInfo("CSC 252", "Algorithms",
//                "200", "Computer Science");
//        CourseInfo course18 = new CourseInfo("CSC 293", "Machine Learning",
//                "200", "Computer Science");
//        CourseInfo course19 = new CourseInfo("CSC 334", "Topics in Computational Biology",
//                "300", "Computer Science");
//        CourseInfo course20 = new CourseInfo("CSC 390", "Artificial Intelligence and Natural Language Understanding",
//                "300", "Computer Science");





//        //MATH
//        CourseInfo course1 = new CourseInfo("MTH 101", "Math Skills Studio",
//                "100", "Mathematics");
//        CourseInfo course2 = new CourseInfo("MTH 102", "Elementary Functions",
//                "100", "Mathematics");
//        CourseInfo course3 = new CourseInfo("MTH 105", "Discovering Mathematics",
//                "100", "Mathematics");
//        CourseInfo course4 = new CourseInfo("MTH 111", "Calculus I",
//                "100", "Mathematics");
//        CourseInfo course5 = new CourseInfo("MTH 112", "Calculus II",
//                "100", "Mathematics");
//        CourseInfo course6 = new CourseInfo("MTH 153", "Introduction to Discrete Mathematics",
//                "100", "Mathematics");
//        CourseInfo course7 = new CourseInfo("MTH 211", "Linear Algebra",
//                "200", "Mathematics");
//        CourseInfo course8 = new CourseInfo("MTH 212", "Calculus III",
//                "200", "Mathematics");
//        CourseInfo course9 = new CourseInfo("MTH 220", "Introduction to Probability and Statistics",
//                "200", "Mathematics");
//        CourseInfo course10 = new CourseInfo("MTH 238", "Topics in Number Theory",
//                "200", "Mathematics");
//        CourseInfo course11 = new CourseInfo("MTH 246", "Probability",
//                "200", "Mathematics");
//        CourseInfo course12 = new CourseInfo("MTH 281", "Introduction to Analysis",
//                "200", "Mathematics");
//        CourseInfo course13 = new CourseInfo("MTH 291", "Multiple Regression",
//                "200", "Mathematics");
//        CourseInfo course14 = new CourseInfo("MTH 300", "Dialogues in Mathematics and Statistics",
//                "300", "Mathematics");
//        CourseInfo course15 = new CourseInfo("MTH 280", "Advanced Calculus",
//                "200", "Mathematics");
//        CourseInfo course16 = new CourseInfo("MTH 301", "Topics in Advanced Mathematics and Statics",
//                "300", "Mathematics");
//        CourseInfo course17 = new CourseInfo("MTH 353", "Advanced Topics in Discrete Applied Mathematics",
//                "300", "Mathematics");
//        CourseInfo course18 = new CourseInfo("MTH 382", "Complex Analysis",
//                "300", "Mathematics");
////        CourseInfo course19 = new CourseInfo("CSC 334", "Topics in Computational Biology",
////                "300", "Computer Science");
////        CourseInfo course20 = new CourseInfo("CSC 390", "Artificial Intelligence and Natural Language Understanding",
////                "300", "Computer Science");

        //German
        CourseInfo course1 = new CourseInfo("GER 110Y", "Elementary German",
                "100", "German");
        CourseInfo course2 = new CourseInfo("GER 200", "Intermediate German",
                "200", "German");
        CourseInfo course3 = new CourseInfo("GER 300", "Topics in German Culture and society",
                "300", "German");
        CourseInfo course4 = new CourseInfo("GER 350", "Seminar: Language and the German Media",
                "300", "German");
        CourseInfo course5 = new CourseInfo("GER 144", "German for reading Knowledge",
                "100", "German");
        CourseInfo course6 = new CourseInfo("GER 161", "The Cultures of German Speaking Europe",
                "100", "German");
        CourseInfo course7 = new CourseInfo("GER 231", "Topics in German Cinema",
                "200", "German");
        CourseInfo course8 = new CourseInfo("GER 260", "German All Over Campus",
                "200", "German");
        CourseInfo course9 = new CourseInfo("GER 360", "Seminar: Advanced Topics In German Studies",
                "300", "German");

        //Arabic
        CourseInfo course10 = new CourseInfo("ARA 100Y", "Elementary Arabic ",
                "100", "Arabic");
        CourseInfo course11 = new CourseInfo("ARA 200", "Intermediate Arabic I ",
                "200", "Arabic");
        CourseInfo course12 = new CourseInfo("ARA 201", "Intermediate Arabic II",
                "200", "Arabic");
        CourseInfo course13 = new CourseInfo("ARA 300", "Advanced Arabic I",
                "300", "Arabic");
        CourseInfo course14 = new CourseInfo("ARA 301", "Advanced Arabic II",
                "300", "Arabic");

        //Engineering
        CourseInfo course15 = new CourseInfo("EGR 100", "Engineering For Everyone",
                "100", "Engineering");
        CourseInfo course29 = new CourseInfo("EGR 110", "Fundamental Engineering Principles",
                "100", "Engineering");
        CourseInfo course16 = new CourseInfo("EGR 220", "Engineering Circuit Theory",
                "200", "Engineering");
        CourseInfo course17 = new CourseInfo("EGR 270", "Engineering Mechanics",
                "200", "Engineering");
        CourseInfo course18 = new CourseInfo("EGR 290", "Engineering Thermodynamics",
                "200", "Engineering");
        CourseInfo course19 = new CourseInfo("EGR 314", "Seminar: Contaminants in Aquatic Systems",
                "300", "Engineering");
        CourseInfo course20 = new CourseInfo("EGR 315", "Ecohydrology",
                "300", "Engineering");
        CourseInfo course21 = new CourseInfo("EGR 350", "Seminar: Engineering and Cancer",
                "300", "Engineering");
        CourseInfo course22 = new CourseInfo("EGR 351", "Seminar: Introduction to Biomedical Engineering",
                "300", "Engineering");
        CourseInfo course23 = new CourseInfo("EGR 374", "Fluid Mechanics",
                "300", "Engineering");
        CourseInfo course24 = new CourseInfo("EGR 375", "Strength of materials",
                "300", "Engineering");
        CourseInfo course25 = new CourseInfo("EGR 388", "Seminar: Photovoltaic and Fuel Cell System Design",
                "300", "Engineering");
        CourseInfo course26 = new CourseInfo("EGR 390", "Advanced topics in Engineering",
                "300", "Engineering");
        CourseInfo course27 = new CourseInfo("EGR 410D", "Engineering Design and Professional Practice",
                "400", "Engineering");
        CourseInfo course28 = new CourseInfo("EGR 422D", "Design Clinic",
                "400", "Engineering");

        List<CourseInfo> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);
        courses.add(course7);
        courses.add(course8);
        courses.add(course9);
        courses.add(course10);
        courses.add(course11);
        courses.add(course12);
        courses.add(course13);
        courses.add(course14);
        courses.add(course15);
        courses.add(course16);
        courses.add(course17);
        courses.add(course18);
        courses.add(course19);
        courses.add(course20);
        courses.add(course21);
        courses.add(course22);
        courses.add(course23);
        courses.add(course24);
        courses.add(course25);
        courses.add(course26);
        courses.add(course27);
        courses.add(course28);
        courses.add(course29);
       //repo.insertMultipleCourses(courses);




    }

    public void submit(View view) {
        intent = new Intent(this, FeedbackDisplay.class);
        intent.putExtra(KEY, courseID);
        startActivity(intent);
    }

}
