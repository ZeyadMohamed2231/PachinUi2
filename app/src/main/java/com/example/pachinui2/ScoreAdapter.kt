package com.example.pachinui2

import com.example.pachinui2.ScoreModel
import androidx.recyclerview.widget.RecyclerView
import com.example.pachinui2.ScoreAdapter.ScoreHandler
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.pachinui2.R
import java.util.ArrayList

class ScoreAdapter(var list: ArrayList<ScoreModel>) : RecyclerView.Adapter<ScoreHandler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreHandler {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_adv, parent, false)
        return ScoreHandler(view)
    }

    override fun onBindViewHolder(holder: ScoreHandler, position: Int) {
        val scoreModel = list[position]
        holder.imageViewScore.setImageResource(scoreModel.imageUri)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ScoreHandler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageViewScore: ImageView

        init {
            imageViewScore = itemView.findViewById(R.id.iv_movie)
        }
    }
}