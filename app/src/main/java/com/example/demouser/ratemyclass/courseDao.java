package com.example.demouser.ratemyclass;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface courseDao {
    @Insert
    void insert(feedbackClass feedback);

    @Query("SELECT * FROM feedback_table WHERE courseID LIKE :name")
    LiveData<List<feedbackClass>> getAllFeedbackBy(String name);

    @Query("DELETE FROM feedback_table")
    void deleteAll();
}
