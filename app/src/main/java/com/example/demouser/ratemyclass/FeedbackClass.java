package com.example.demouser.ratemyclass;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "feedback_table")
public class FeedbackClass {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="courseID")
    private String courseID;
    @ColumnInfo(name="professor")
    private String professor;
    @ColumnInfo(name="hoursSpent")
    private String hoursSpent;
    @ColumnInfo(name="semester")
    private String semester;
    @ColumnInfo(name="quizzes")
    private String quizzes;
    @ColumnInfo(name="midtermF")
    private String midtermF;
    @ColumnInfo(name="finalF")
    private String finalF;
    @ColumnInfo(name="feedbackText")
    private String feedbackText;

    public FeedbackClass(String professor, String hoursSpent, String semester, String quizzes, String midtermF,
                         String finalF, String feedbackText, String courseID) {
        this.courseID = courseID;
        this.professor = professor;
        this.hoursSpent = hoursSpent;
        this.semester = semester;
        this.quizzes = quizzes;
        this.midtermF = midtermF;
        this.finalF = finalF;
        this.feedbackText = feedbackText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getProfessor() {
        return professor;
    }

    public String getHoursSpent() {
        return hoursSpent;
    }

    public String getSemester() {
        return semester;
    }

    public String getQuizzes() {
        return quizzes;
    }

    public String getMidtermF() {
        return midtermF;
    }

    public String getFinalF() {
        return finalF;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public void setFinalF(String finalF) {
        this.finalF = finalF;
    }

    public void setHoursSpent(String hoursSpent) {
        this.hoursSpent = hoursSpent;
    }

    public void setMidtermF(String midtermF) {
        this.midtermF = midtermF;
    }

    public void setQuizzes(String quizzes) {
        this.quizzes = quizzes;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

}
