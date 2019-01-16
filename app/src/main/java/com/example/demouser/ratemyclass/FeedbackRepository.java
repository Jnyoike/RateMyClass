package com.example.demouser.ratemyclass;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class FeedbackRepository {
    private FeedbackDao courseDao;


    public FeedbackRepository(Application application){
        FeedbackDatabase db = FeedbackDatabase.getDatabase(application);
        courseDao = db.courseDao();

    }

    LiveData<List<FeedbackClass>> getFeedbacks(String courseID){
        return courseDao.getAllFeedbackBy(courseID);
    }

    public void insert(FeedbackClass feedback){
        new insertAsyncTask(courseDao).execute(feedback);

    }

    LiveData<List<String>> getCourseDepartments(){
        return courseDao.getCourseDepartments();
    }

    LiveData<List<String>> getCourseLevels(String dept){
        return courseDao.getCourseLevels(dept);

    }

    LiveData<List<String>> getCourseIDs(String level, String dept){
        return courseDao.getCourseID(level, dept);
    }
    LiveData<String> getCourseName(String id){
        return courseDao.getCourseName(id);
    }


    private static class insertAsyncTask extends AsyncTask<FeedbackClass, Void, Void> {
        private FeedbackDao mAsyncTaskDao;

        insertAsyncTask(FeedbackDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final FeedbackClass... feedbackClasses) {
            mAsyncTaskDao.insert(feedbackClasses[0]);
            return null;
        }
    }
    public void delete(){
        new deleteAsyncTask(courseDao).execute();

    }
    private static class deleteAsyncTask extends AsyncTask<Void, Void, Void> {
        private FeedbackDao mAsyncTaskDao;

        deleteAsyncTask(FeedbackDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    public void insertCourse( CourseInfo course ){
        new insertCourseAsyncTask(courseDao).execute(course);

    }
    private static class insertCourseAsyncTask extends AsyncTask<CourseInfo, Void, Void> {
        private FeedbackDao mAsyncTaskDao;

        insertCourseAsyncTask(FeedbackDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final CourseInfo... courses) {
            mAsyncTaskDao.insert(courses[0]);
            return null;
        }
    }

    public void insertMultipleCourses ( List<CourseInfo> courses ){
        new insertMultipleCoursesAsyncTask(courseDao).execute(courses);

    }
    private static class insertMultipleCoursesAsyncTask extends AsyncTask<List<CourseInfo>, Void, Void> {
        private FeedbackDao mAsyncTaskDao;

        insertMultipleCoursesAsyncTask(FeedbackDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<CourseInfo>... courses) {
            mAsyncTaskDao.insert(courses[0]);
            return null;
        }
    }

}
