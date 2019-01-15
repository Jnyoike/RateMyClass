package com.example.demouser.ratemyclass;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {FeedbackClass.class, CourseInfo.class}, version = 2, exportSchema = false)
public abstract class FeedbackDatabase extends RoomDatabase {
    public abstract FeedbackDao courseDao();
    private static volatile FeedbackDatabase INSTANCE;

    static FeedbackDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (FeedbackDatabase.class) {
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder
                            (context.getApplicationContext(), FeedbackDatabase.class,
                                    "feedback_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
