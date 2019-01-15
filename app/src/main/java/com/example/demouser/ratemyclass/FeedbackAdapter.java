package com.example.demouser.ratemyclass;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackHolder> {
    private List<FeedbackClass> cards;

    public FeedbackAdapter() {

        this.cards = new ArrayList<>();
    }

    @Override
    public FeedbackHolder onCreateViewHolder(ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.feedback_card, parent, false);
        return new FeedbackHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedbackHolder cardHolder, int position) {
        cardHolder.bindCard(cards.get(position));
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    // set
    public void setCards(List<FeedbackClass> cards){
        this.cards = cards;

        notifyDataSetChanged();
    }
}
