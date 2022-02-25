package com.example.pachinui2.secondfragments

import com.example.pachinui2.ScoreModel
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pachinui2.R
import com.example.pachinui2.ScoreAdapter
import java.util.ArrayList

class ScoreFragment : Fragment() {
    var score_products = ArrayList<ScoreModel>()
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_score, container, false)
        recyclerView = view.findViewById(R.id.rv_advs)
        prepareData()
        val socreAdapter = ScoreAdapter(score_products)
        recyclerView!!.setAdapter(socreAdapter)
        return view
    }

    private fun showFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout2, fragment)
            .commit()
    }

    private fun prepareData() {
        val scoreModel = ScoreModel(R.drawable.logo)
        score_products.add(scoreModel)
        val scoreModel1 = ScoreModel(R.drawable.splash)
        score_products.add(scoreModel1)
        val scoreModel2 = ScoreModel(R.drawable.image)
        score_products.add(scoreModel2)
    }
}