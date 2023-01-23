package com.example.pifsportapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pifsportapp.R
import com.example.pifsportapp.data.UserData

// on below line we are creating
// a course rv adapter class.
class MatchDetailsAdapter (

    // on below line we are passing variables
    // as course list and context
    private val courseList: MutableList<UserData>,
    //private val context: Context


) : RecyclerView.Adapter<MatchDetailsAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MatchDetailsAdapter.CourseViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_match_details,
            parent, false
        )
        // at last we are returning our view holder
        // class with our item View File.
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchDetailsAdapter.CourseViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.UserNameTV.text = courseList.get(position).userName
        holder.UserIV.setImageResource(courseList.get(position).userImg)
    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our size of our list
        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val UserNameTV: TextView = itemView.findViewById(R.id.tv_username)
        val UserIV: ImageView = itemView.findViewById(R.id.iv_user)
    }
}

