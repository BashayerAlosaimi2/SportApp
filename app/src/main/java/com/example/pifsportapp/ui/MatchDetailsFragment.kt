package com.example.pifsportapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pifsportapp.R
import com.example.pifsportapp.adapter.MatchDetailsAdapter
import com.example.pifsportapp.data.UserData

class MatchDetailsFragment : Fragment() {
    lateinit var usersRV: RecyclerView
    lateinit var matchDetailsAdapter: MatchDetailsAdapter
    lateinit var usersList: ArrayList<UserData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_details, container, false)

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // on below line we are initializing
        // our views with their ids.
        usersRV = view.findViewById(R.id.rv_users)

        // on below line we are initializing our list
        usersList = ArrayList()

        // on below line we are creating a variable
        // for our grid layout manager and specifying
        // column count as 2
        val layoutManager = GridLayoutManager(context, 4)

        usersRV.layoutManager = layoutManager

        // on below line we are initializing our adapter
        matchDetailsAdapter = MatchDetailsAdapter(usersList)

        // on below line we are setting
        // adapter to our recycler view.
        usersRV.adapter = matchDetailsAdapter

        // on below line we are adding data to our list
        usersList.add(UserData("Ahmad", R.drawable.user))
        usersList.add(UserData("shaden", R.drawable.woman))
        usersList.add(UserData("Sami", R.drawable.man))
        usersList.add(UserData("Farah", R.drawable.man2))
        usersList.add(UserData("Eman", R.drawable.user2))

        // on below line we are notifying adapter
        // that data has been updated.
        matchDetailsAdapter.notifyDataSetChanged()


    }

}