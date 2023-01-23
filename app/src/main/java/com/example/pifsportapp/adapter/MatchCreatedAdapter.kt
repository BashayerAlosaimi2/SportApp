package com.example.pifsportapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pifsportapp.R
import com.example.pifsportapp.ViewModel.MatchViewModel
import com.example.pifsportapp.data.MatchCreatedData

class MatchCreatedAdapter (
// below line we are passing variables
    // as course list and context
    private val  matchList: List<MatchCreatedData>,
    private val  VM: MatchViewModel,

    //private val context: Context

) : RecyclerView.Adapter<MatchCreatedAdapter.MatchViewHolder>() {
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): MatchCreatedAdapter.MatchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_create_match,
            parent, false
        )
        // at last we are returning our view holder
        // class with our item View File.
        return MatchViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.dateTV.text = matchList.get(position).date
        holder.timeTV.text = matchList.get(position).time
        holder.locationTV.text = matchList.get(position).location


        holder.joinBtn.setOnClickListener{

            // here we going to add user
        }
    }
    override fun getItemCount(): Int {
        // on below line we are
        // returning our size of our list
        return matchList.size
    }

    class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val dateTV: TextView = itemView.findViewById(R.id.tv_username)
        val timeTV: TextView = itemView.findViewById(R.id.tv_username)
        val locationTV: TextView = itemView.findViewById(R.id.tv_username)
        val joinBtn: TextView = itemView.findViewById(R.id.tv_username)
    }


}


