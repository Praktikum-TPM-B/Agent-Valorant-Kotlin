package com.maulanakurnia.agentvalorant.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.maulanakurnia.agentvalorant.R
import com.maulanakurnia.agentvalorant.model.AgentModel
import com.maulanakurnia.agentvalorant.ui.DetailActivity

class AgentAdapter(private val listAgent: ArrayList<AgentModel>, private val context: Context) :
    RecyclerView.Adapter<AgentAdapter.AgentHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card_recyclerview, parent, false)
        return AgentHolder(view)
    }

    override fun onBindViewHolder(holder: AgentHolder, position: Int) {
        val (image, name, role, summary) = listAgent[position]

        Glide.with(holder.itemView.context)
            .load(image)
            .apply(RequestOptions().override(350, 550))
            .into(holder.image)

        holder.name.text = name
        holder.role.text = role
        holder.summary.text = summary

        holder.btnPreview.setOnClickListener {
            openDetailActivity(image,name,role,summary)
        }
        holder.btnShare.setOnClickListener {
            shareAgent(name,summary)
        }
    }

    override fun getItemCount(): Int {
        return listAgent.size
    }

    inner class AgentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView    = itemView.findViewById(R.id.agent_image)
        var name: TextView      = itemView.findViewById(R.id.agent_name)
        var role: TextView      = itemView.findViewById(R.id.agent_role)
        var summary: TextView   = itemView.findViewById(R.id.agent_summary)
        var btnPreview: Button  = itemView.findViewById(R.id.btnPreview)
        var btnShare: Button    = itemView.findViewById(R.id.btnShare)
    }

    private fun openDetailActivity(vararg agent: String) {
        val i = Intent(context, DetailActivity::class.java)
        i.putExtra("IMAGE_KEY", agent[0])
        i.putExtra("NAME_KEY", agent[1])
        i.putExtra("ROLE_KEY", agent[2])
        i.putExtra("SUMMARY_KEY", agent[3])
        context.startActivity(i)
    }

    private fun shareAgent(vararg agent: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, agent[0] + "\n\n" + agent[1])
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        context.startActivity(shareIntent)
    }

}