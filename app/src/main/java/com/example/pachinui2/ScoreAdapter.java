package com.example.pachinui2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreHandler> {


    ArrayList<ScoreModel> list;

    public ScoreAdapter(ArrayList<ScoreModel> list) {
        this.list = list;
    }


    @Override
    public ScoreHandler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adv,parent,false);
        ScoreHandler scoreHandler = new ScoreHandler(view);
        return scoreHandler;
    }

    @Override
    public void onBindViewHolder(ScoreAdapter.ScoreHandler holder, int position) {

        ScoreModel scoreModel = list.get(position);
        holder.imageViewScore.setImageResource(scoreModel.getImageUri());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ScoreHandler extends RecyclerView.ViewHolder{
        ImageView imageViewScore;

        public ScoreHandler(@NonNull View itemView){
            super(itemView);

            imageViewScore = itemView.findViewById(R.id.iv_movie);

        }
    }
}
