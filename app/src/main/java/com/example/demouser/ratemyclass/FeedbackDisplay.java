package com.example.demouser.ratemyclass;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class FeedbackDisplay extends AppCompatActivity {
    Intent intent;
    List<FeedbackClass> cards;
    FeedbackAdapter adapter;
    FeedbackRepository rep;
    // USE THE INTENT THING TO GET THE COURSE ID FROM THE WELCOME PAGE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_display);

        RecyclerView cardList = (RecyclerView) findViewById(R.id.cardList);
        cardList.setLayoutManager(new LinearLayoutManager(this));
        //List<FeedbackClass> cards = loadCardsFromDatabase();
        adapter = new FeedbackAdapter();
        cardList.setAdapter(adapter);

        rep = new FeedbackRepository(getApplication());

        rep.getFeedbacks("CSC 111").observe(this, new Observer<List<FeedbackClass>>() {
            @Override
            public void onChanged(@Nullable List<FeedbackClass> feedbackClasses) {
                adapter.setCards(feedbackClasses);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(FeedbackDisplay.this, FeedbackForm.class);
                startActivity(intent);
            }
        });
    }
    public void deleteButton(View view){
        rep.delete();
    }

   /** public List<FeedbackClass> loadCardsFromDatabase() {
        FeedbackClass firstCard  = new FeedbackClass("Nick", "10", "Fall 2018",
                "Yes", "Takehome", "Self-scheduled","It was great!", "CSC 111");
        FeedbackClass secondCard  = new FeedbackClass("Dominique", "10", "Fall 2018",
                "Yes", "Takehome", "Self-scheduled","It was great!", "CSC 111");
        FeedbackClass thirdCard  = new FeedbackClass("Sara", "10", "Fall 2018",
                "Yes", "Takehome", "Self-scheduled","It was great!", "CSC 111");
        FeedbackClass fourthCard  = new FeedbackClass("JJ", "10", "Fall 2018",
                "Yes", "Takehome", "Self-scheduled","AJKDGHAKDHKAS FADJHG " +
                "KAJSDHGKAJ SDHGAS HGKJASHG ASJGH SJDHGA JSKDHG SKGHAKJSDG LGHSALJKD GKADHG ASDKJHG SJDHG AKJG. ", "CSC 111");

        cards = new ArrayList<>();
        cards.add(firstCard);
        cards.add(secondCard);
        cards.add(thirdCard);
        cards.add(fourthCard);

        return cards;
    } **/




}
