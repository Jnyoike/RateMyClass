package com.example.demouser.ratemyclass;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demouser.ratemyclass.R;
import com.example.demouser.ratemyclass.cardHolder;
import com.example.demouser.ratemyclass.feedbackClass;

import java.util.List;

public class courseAdapter extends RecyclerView.Adapter<cardHolder> {
    private List<feedbackClass> cards;

    public courseAdapter (List<feedbackClass> cards) {
        this.cards = cards;
    }

    @Override
    public cardHolder onCreateViewHolder(ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.feedback_card, parent, false);
        return new cardHolder(view);
    }

    @Override
    public void onBindViewHolder( cardHolder cardHolder, int position) {
        cardHolder.bindCard(cards.get(position));
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
