package com.example.demouser.ratemyclass;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class feedbackRepository {
    private courseDao courseDao;
    private LiveData<List<feedbackClass>> feedbacks;

    public feedbackRepository(Application application){
        feedbackDatabase db = feedbackDatabase.getDatabase(application);
        courseDao = db.courseDao();
        feedbacks = courseDao.getAllFeedbackBy("CSC 111");
    }

    LiveData<List<feedbackClass>> getFeedbacks(){
        return feedbacks;
    }
    public void insert(feedbackClass feedback){
        new insertAsyncTask(courseDao).execute(feedback);

    }
    private static class insertAsyncTask extends AsyncTask<feedbackClass, Void, Void> {
        private courseDao mAsyncTaskDao;

        insertAsyncTask(courseDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final feedbackClass... feedbackClasses) {
            mAsyncTaskDao.insert(feedbackClasses[0]);
            return null;
        }
    }
    public void delete(){
        new deleteAsyncTask(courseDao).execute();

    }
    private static class deleteAsyncTask extends AsyncTask<Void, Void, Void> {
        private courseDao mAsyncTaskDao;

        deleteAsyncTask(courseDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

}
