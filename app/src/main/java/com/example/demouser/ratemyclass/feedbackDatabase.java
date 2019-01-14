package com.example.demouser.ratemyclass;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {feedbackClass.class}, version = 1, exportSchema = false)
public abstract class feedbackDatabase extends RoomDatabase {
    public abstract courseDao courseDao();
    private static volatile feedbackDatabase INSTANCE;

    static feedbackDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (feedbackDatabase.class) {
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder
                            (context.getApplicationContext(), feedbackDatabase.class,
                                    "feedback_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
