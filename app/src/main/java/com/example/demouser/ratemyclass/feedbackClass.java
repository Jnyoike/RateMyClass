package com.example.demouser.ratemyclass;

public class feedbackClass {
    private String professor;
    private String hoursSpent;
    private String semester;
    private String quizzes;
    private String midtermF;
    private String finalF;
    private String feedbackText;

    public  feedbackClass ( String professor, String hoursSpent, String semester, String quizzes, String midtermF, String finalF, String feedbackText) {
        this.professor = professor;
        this.hoursSpent = hoursSpent;
        this.semester = semester;
        this.quizzes = quizzes;
        this.midtermF = midtermF;
        this.finalF = finalF;
        this.feedbackText = feedbackText;
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
