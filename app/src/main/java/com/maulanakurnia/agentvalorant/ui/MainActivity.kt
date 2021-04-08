package com.maulanakurnia.agentvalorant.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maulanakurnia.agentvalorant.R
import com.maulanakurnia.agentvalorant.adapter.AgentAdapter
import com.maulanakurnia.agentvalorant.data.AgentData
import com.maulanakurnia.agentvalorant.model.AgentModel

class MainActivity : AppCompatActivity() {

    private lateinit var rvAgent: RecyclerView
    private var list: ArrayList<AgentModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Agent Valorant"

        rvAgent = findViewById(R.id.rvAgent)
        rvAgent.setHasFixedSize(true)
        list.addAll(AgentData.listData)
        showRecyclerCardView()
    }

    private fun showRecyclerCardView() {
        rvAgent.layoutManager = LinearLayoutManager(this)
        val cardviewAgentAdapter = AgentAdapter(list,this)
        rvAgent.adapter = cardviewAgentAdapter
    }
}