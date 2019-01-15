package com.example.demouser.ratemyclass;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "course_table")
public class CourseInfo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "courseID")
    private String courseID;
    @ColumnInfo(name = "courseName")
    private String courseName;
    @ColumnInfo(name = "courseLevel")
    private String courseLevel;
    @ColumnInfo(name = "courseDepartment")
    private String courseDepartment;

    public CourseInfo(String courseID, String courseName, String courseLevel, String courseDepartment) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseLevel = courseLevel;
        this.courseDepartment = courseDepartment;
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseDepartment(String courseDepartment) {
        this.courseDepartment = courseDepartment;
    }


    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setId(int id) {
        this.id = id;
    }
}
