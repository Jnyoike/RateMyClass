package com.example.demouser.ratemyclass;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class FeedbackHolder extends RecyclerView.ViewHolder {
    TextView professor;
    TextView hoursSpent;
    TextView semester;
    TextView quizzes;
    TextView midtermF;
    TextView finalF;
    TextView feedbackText;

    public FeedbackHolder(View cardView ){
        super(cardView);

        professor = (TextView) cardView.findViewById(R.id.professor);
        hoursSpent = (TextView) cardView.findViewById(R.id.hours);
        semester = (TextView) cardView.findViewById(R.id.semester);
        quizzes = (TextView) cardView.findViewById(R.id.quizzes);
        midtermF = (TextView) cardView.findViewById(R.id.midterm);
        finalF = (TextView) cardView.findViewById(R.id.FINAL);
        feedbackText = (TextView) cardView.findViewById(R.id.feedback);
    }

    public void bindCard ( FeedbackClass feed) {
        professor.setText(feed.getProfessor());
        hoursSpent.setText(feed.getHoursSpent());
        semester.setText(feed.getSemester());
        quizzes.setText(feed.getQuizzes());
        midtermF.setText(feed.getMidtermF());
        finalF.setText(feed.getFinalF());
        feedbackText.setText(feed.getFeedbackText());
    }


}
