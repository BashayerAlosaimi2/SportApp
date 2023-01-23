package com.example.pifsportapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pifsportapp.R
import com.facebook.shimmer.ShimmerFrameLayout

class ProfileFragment : Fragment() {
    lateinit var shimmring : ShimmerFrameLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)



    }
    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shimmring  = view.findViewById(R.id.shimmer_view_container)
        //shimmring.showShimmer(true)
        shimmring.hideShimmer()
    }


}