package com.example.demouser.ratemyclass;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FeedbackDao {
    @Insert
    void insert(FeedbackClass feedback);

    @Insert
    void insert(CourseInfo course);

    @Insert
    void insert(List<CourseInfo> courses);

    @Query("SELECT * FROM feedback_table WHERE courseID LIKE :name")
    LiveData<List<FeedbackClass>> getAllFeedbackBy(String name);

    @Query("DELETE FROM feedback_table")
    void deleteAll();

    @Query("SELECT DISTINCT courseLevel FROM course_table WHERE courseDepartment LIKE :department ORDER BY courseLevel ASC")
    LiveData<List<String>> getCourseLevels(String department);

    @Query("SELECT DISTINCT courseDepartment FROM course_table ORDER BY courseDepartment ASC")
    LiveData<List<String>> getCourseDepartments();

    @Query("SELECT courseID FROM course_table WHERE courseLevel LIKE :level AND courseDepartment LIKE :department ORDER BY courseID ASC")
    LiveData<List<String>> getCourseID(String level, String department);

    @Query("SELECT DISTINCT courseName FROM course_table WHERE courseID LIKE :id")
    LiveData<String> getCourseName(String id);

}
