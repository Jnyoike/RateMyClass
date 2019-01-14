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

import java.util.ArrayList;
import java.util.List;

public class feedBackDisplay extends AppCompatActivity {
    Intent intent;
    List<feedbackClass> cards;
    courseAdapter adapter;
    feedbackRepository rep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_display);

        RecyclerView cardList = (RecyclerView) findViewById(R.id.cardList);
        cardList.setLayoutManager(new LinearLayoutManager(this));
        //List<feedbackClass> cards = loadCardsFromDatabase();
        adapter = new courseAdapter();
        cardList.setAdapter(adapter);

        rep = new feedbackRepository(getApplication());

        rep.getFeedbacks().observe(this, new Observer<List<feedbackClass>>() {
            @Override
            public void onChanged(@Nullable List<feedbackClass> feedbackClasses) {
                adapter.setCards(feedbackClasses);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(feedBackDisplay.this, FeedBackActivity.class);
                startActivity(intent);
            }
        });
    }
    public void deleteButton(View view){
        rep.delete();
    }

   /** public List<feedbackClass> loadCardsFromDatabase() {
        feedbackClass firstCard  = new feedbackClass("Nick", "10", "Fall 2018",
                "Yes", "Takehome", "Self-scheduled","It was great!", "CSC 111");
        feedbackClass secondCard  = new feedbackClass("Dominique", "10", "Fall 2018",
                "Yes", "Takehome", "Self-scheduled","It was great!", "CSC 111");
        feedbackClass thirdCard  = new feedbackClass("Sara", "10", "Fall 2018",
                "Yes", "Takehome", "Self-scheduled","It was great!", "CSC 111");
        feedbackClass fourthCard  = new feedbackClass("JJ", "10", "Fall 2018",
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
