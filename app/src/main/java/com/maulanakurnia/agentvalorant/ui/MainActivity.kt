package com.maulanakurnia.agentvalorant.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maulanakurnia.agentvalorant.R
import com.maulanakurnia.agentvalorant.adapter.AgentAdapter
import com.maulanakurnia.agentvalorant.data.AgentData
import com.maulanakurnia.agentvalorant.model.Agent

class MainActivity : AppCompatActivity() {

    private lateinit var rvAgent: RecyclerView
    private var list: ArrayList<Agent> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle("Agent Valorant")

        rvAgent = findViewById(R.id.rvAgent)
        rvAgent.setHasFixedSize(true)
        list.addAll(AgentData.listData)
        showRecyclerCardView()
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun showRecyclerCardView() {
        rvAgent.layoutManager = LinearLayoutManager(this)
        val cardviewAgentAdapter = AgentAdapter(list,this)
        rvAgent.adapter = cardviewAgentAdapter
    }
}